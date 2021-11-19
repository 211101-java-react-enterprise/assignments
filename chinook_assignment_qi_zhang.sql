/*
 * Revature Associate SQL Workbook
 * 			Part I – Working with an existing database
*/

--Task – Select all records from the Employee table.
select * from "Employee";       					  ---note: PostgresSQL column name are case sensitive if enclosed with ""

--Task – Select all records from the Employee table where last name is King.
select * from "Employee" where "LastName"= 'King' ;   ---note: entry varchar enclosed by ''

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from "Employee" where "FirstName"= 'Andrew' and "ReportsTo"is null;   ---note: use is instead of = to check if entry null

--Task – Select all albums in album table and sort result set in descending order
select * from "Album" order by "AlbumId" desc;

--Task – Select first name from Customer and sort result set in ascending order
select "FirstName" from "Customer" order by "FirstName" asc;

--Task – Insert two new records into Genre table
insert into "Genre" ("GenreId","Name") values (26,'Historical'),(27,'Anime');  ---note: (),() can be used to insert multiple rows

--Task – Insert two new records into Employee table
insert into "Employee" ("EmployeeId","LastName","FirstName","Title","ReportsTo","BirthDate",
			"HireDate","Address","City","State","Country","PostalCode","Phone","Fax","Email")
		     values(9,'White','Emily','Human Resource',10,to_timestamp(1974-8-9),to_timestamp(2004-04-05),'123 Hill Street','Lethbridge',
		            'AB','Canada','T1H9Z7','+1(403)115-9878','+1(403)991-7385','emily@chinookcorp.com'),
		           (10,'Hall','Albert','Human Resource Manager',1,to_timestamp(1963-10-8),to_timestamp(2002-10-4),'45 Elm Street','Lethbridge',
		            'AB','Canada','S1H123','+1(403)234-4950','+1(403)234-568','albert@chinookcorp.com');
				---note: sql timstamp cast: to_timestamp(int)
		           
--Task – Insert two new records into Employee table		           
insert into "Customer"("CustomerId","FirstName","LastName","Email")
			values(60,'Bob','Bailey','Bob@hotmail.com'),(61,'Henry','Brown','Henry@Hotmail.com');		           
		           
--Task – Update Aaron Mitchell in Customer table to Robert Walter
update "Customer" set "FirstName"='Robert',"LastName"='Walter'where "FirstName"='Aaron'and"LastName"='Mitchell';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
update "Artist" set "Name" ='CCR'where"Name"='Creedence Clearwater Revival';

--Task – Select all invoices with a billing address like “T”
select * from "Invoice" where "BillingAddress" like 'T%';

--Task – Select all invoices that have a total between 15 and 50
select * from "Invoice" where "Total" between 15 and 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from "Employee" where "HireDate" between to_date('01 Jun 2003','DD Mon YYYY')and to_date('01 Mar 2004','DD Mon YYYY') ;

--Task – Delete a record in Customer table where the name is Robert Walter.
delete from "InvoiceLine" where "InvoiceId" in (select "InvoiceId" from "Invoice" where "CustomerId"=32);
delete from "Invoice" where "CustomerId"=32;
delete from "Customer" where "FirstName" ='Robert'and "LastName"='Walter';


--Task – Create a query that leverages a system-defined function to return the current time.
select current_time;

--Task – Create a query that leverages a system-defined function to return the length of a mediatype from the mediatype table
select length("Name")from "MediaType";

--Task – Create a query that leverages a system-defined function to return the average total of all invoices
select avg("Total") as "Average Total" from "Invoice";

--Task – Create a query that leverages a system-defined function to return the most expensive track
select * from "Track" where "UnitPrice" in (select greatest("UnitPrice") from "InvoiceLine");

--Task – Create a function that returns the average price of invoice-line items in the invoice-line table
create function invoice_line_avg_price()
returns decimal
language plpgsql
as
$$
	declare avg_price decimal;
	begin
		select avg("UnitPrice") into avg_price from "InvoiceLine";
	return avg_price;
	end
$$

select invoice_line_avg_price();

drop function birthdate_after;

--Task – Create a function that returns all employees who are born after 1968
select * from "Employee" where "BirthDate" > to_date('05 Dec 1968', 'DD Mon YYYY');
create function birthdate_after(d_m_y varchar)
returns table (
				"EmployeeId" INT,"LastName" VARCHAR(20),"FirstName" VARCHAR(20),"Title" VARCHAR(30),"ReportsTo" INT,
			    "BirthDate" TIMESTAMP,"HireDate" TIMESTAMP,"Address" VARCHAR(70),"City" VARCHAR(40),"State" VARCHAR(40),
			    "Country" VARCHAR(40),"PostalCode" VARCHAR(10),"Phone" VARCHAR(24),"Fax" VARCHAR(24),"Email" VARCHAR(60)
			  )
language plpgsql
as
$$
	begin
	return query 
	select * from "Employee" e where e."BirthDate"> to_date(d_m_y,'DD Mon YYYY');
	end;
$$

select * from birthdate_after('31 Dec 1968');


--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select "Customer"."FirstName","Customer"."LastName", "Invoice"."InvoiceId" 
	 from "Customer"  inner join "Invoice" on "Customer"."CustomerId" ="Invoice"."CustomerId" ;

--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
select "Customer"."CustomerId","Customer"."FirstName" ,"Customer"."LastName" ,"Invoice"."InvoiceId" ,"Invoice"."Total" 
	from "Customer" full outer join "Invoice" on "Customer"."CustomerId" ="Invoice"."CustomerId";

--Task – Create a right join that joins album and artist specifying artist name and title.
select "Artist"."Name","Album"."Title" from "Artist" right join "Album" on "Artist"."Name" ="Album"."Title" ;

--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from "Artist" cross join "Album"  order by "Artist"."Name" asc;

--Task – Perform a self-join on the employee table, joining on the reports to column.
select e1."EmployeeId", e1."FirstName",e1."LastName",e1."Title",e1."ReportsTo", e2."Title",e2."FirstName"
	from "Employee" e1, "Employee" e2 where e1."ReportsTo" =e2."EmployeeId" ;






