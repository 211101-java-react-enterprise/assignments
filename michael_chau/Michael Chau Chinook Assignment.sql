/*2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.*/
select * from employee;
select * from employee where "LastName" = 'King';
select * from employee 
where "FirstName" = 'Andrew' and "ReportsTo" is null;

/*2.2 ORDER BY
Task – Select all albums in album table and sort result set in descending order
Task – Select first name from Customer and sort result set in ascending order*/
select * from album order by "AlbumId" desc;
select "FirstName" from customer order by "FirstName" asc;

/*2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table*/
insert into genre values (26,'Chaos');
insert into employee values
	(9,'Cha','Michael','General Manager',1,'1994-02-18 00:00:00.000',current_date,'211181 Rev ave', 'Rev City','FL',	'USA','23421',	'+1 (780) 428-9482','+1 (780) 428-3457','michael@chinookcorp.com'),
	(10,'Cha','Michael','General Manager',1,current_date,current_date,'211181 Rev ave', 'Rev City','FL',	'USA','23421',	'+1 (780) 428-9482','+1 (780) 428-3457','michael@chinookcorp.com');
insert into customer("CustomerId","FirstName","LastName","Email") values
	(60,'Michael','Chau','Michael@rev.com'),
	(61,'Hello','Moto','Moto@rev.com');

/*2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist “Creedence Clearwater Revival” to “CCR”*/
update customer
set "LastName" = 'Walter', "FirstName" = 'Robert'
where "LastName" = 'Mitchell'and "FirstName" = 'Aaron';
update artist
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

/*2.5 LIKE
Task – Select all invoices with a billing address like “T”*/
select * from invoice
where "BillingAddress" like '%T%';

/*2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50

Task – Select all employees hired between 1st of June 2003 and 1st of March 2004*/
select * from invoice
where "Total" >15 and "Total" < 50;
select * from employee
where "HireDate" > '2003-06-01' and "HireDate"<'2004-03-01';

/*2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).*/
select * from customer
where "FirstName" = 'Robert' and "LastName" = 'Walter';

delete from invoice 
where "CustomerId" = 32;

select * from invoice 
where "CustomerId" =32;

alter table invoice
	drop constraint "FK_InvoiceCustomerId",
	add constraint "FK_InvoiceCustomerId"
	foreign key ("CustomerId") references customer ("CustomerId") on delete cascade;

alter table invoice_line
	drop constraint "FK_InvoiceLineInvoiceId",
	add constraint "FK_InvoiceLineInvoiceId"
	foreign key ("InvoiceId") references invoice ("InvoiceId") on delete cascade;

delete from customer
where "FirstName" = 'Robert' and "LastName" = 'Walter';

/*3.0 SQL Functions
In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database*/

/*3.1 System Defined Functions
Task – Create a query that leverages a system-defined function to return the current time.
Task – Create a query that leverages a system-defined function to return the length of a mediatype from the mediatype table*/
select current_timestamp;
select length("Name") as length
from media_type mt;

/*3.2 System Defined Aggregate Functions
Task – Create a query that leverages a system-defined function to return the average total of all invoices
Task – Create a query that leverages a system-defined function to return the most expensive track*/
select sum("Total") as Total from invoice;
select avg("Total") as AverageTotal from invoice;
select max("UnitPrice") as MostExpensive from track;

/*3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoice-line items in the invoice-line table*/
create or replace function avgItemPrice ()
returns numeric
as $$
	begin
		return avg("UnitPrice")
		from invoice_line;
	end
$$ language plpgsql;

select avgItemPrice();

/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.*/
create or replace function eBornAfter68()
returns setof employee
as $$
	begin
		return query
			select * from employee where "BirthDate" > '1968-01-01'; 
	end
$$ language plpgsql;

select eBornAfter68();
/*4.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.*/


/*4.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.*/
select c."FirstName", c."LastName" , i."InvoiceId" from customer c
inner join invoice i on c."CustomerId" = i."CustomerId";

/*4.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.*/
select customer."CustomerId", customer."FirstName", customer."LastName", i."InvoiceId", i."Total" from customer
full outer join invoice i on customer."CustomerId" = i."CustomerId";

/*4.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.*/
select * from album a
right join artist on a."ArtistId" = artist."ArtistId" ;

/*4.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.*/
select * from album a 
cross join artist
order by artist."Name" asc;

/*4.5 SELF
Task – Perform a self-join on the employee table, joining on the reports to column. */
select * from employee e1
join employee e2 on e1."ReportsTo" = e2."EmployeeId" ;




















































































