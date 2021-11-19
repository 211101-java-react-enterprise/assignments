/*
 *		Andrew Aslakson
 *		Chinook DataBase SQL Workbook
 *		11-18-2021
 */


-- 1.0
-- Done, Database is Loaded

--***********************************************************
-- 2.0
-- 2.1

select * from "Employee";

select * 
from "Employee" 
where "LastName" = 'King';

select *
from "Employee"
where "FirstName" = 'Andrew'
and "ReportsTo" is null;

--------------------------------------------------------------
--2.2

select *
from "Album" a
order by "AlbumId" desc;

select "FirstName"
from "Customer" c 
order by "FirstName" asc;

---------------------------------------------------------------
--2.3

--select * from "Genre" g;

insert into "Genre" ("GenreId", "Name")
values (26, 'New Genre 1'),
	   (27, 'New Genre 2');

--select * from "Employee" e;

insert into "Employee" 
(	"EmployeeId", "LastName", "FirstName", "Title", "ReportsTo",
    "BirthDate", "HireDate", "Address", "City", "State", "Country",
    "PostalCode", "Phone", "Fax", "Email")
values
( 	9, 'LastName', 'FirstName', 'Title', 1,
	to_date('02 Feb 1984', 'DD Mon YYYY'), to_date('07 Jan 2003', 'DD Mon YYYY'), 'Address', 'City', 'AB', 'Canada',
	'Code', '+1 (101) 555-1337', '+1 (101) 555-1337', 'email@email.email'),
( 	10, 'LastName', 'FirstName', 'Title', 1,
	to_date('02 Feb 1984', 'DD Mon YYYY'), to_date('07 Jan 2003', 'DD Mon YYYY'), 'Address', 'City', 'AB', 'Canada',
	'Code', '+1 (101) 555-1337', '+1 (101) 555-1337', 'email@email.email');

--select * from "Customer" c;

insert into "Customer" 
(	"CustomerId", "LastName", "FirstName", "Company",
     "Address", "City", "State", "Country",
    "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
values
( 	60, 'LastName', 'FirstName', null,
	'Address', 'City', 'AB', 'Canada',
	'Code', '+1 (101) 555-1337', '+1 (101) 555-1337', 'email@email.email', 9),
( 	61, 'LastName', 'FirstName', null,
	'Address', 'City', 'AB', 'Canada',
	'Code', '+1 (101) 555-1337', '+1 (101) 555-1337', 'email@email.email', 9);

-----------------------------------------------------------------------------
--2.4

--select * from "Customer" c;

update "Customer" 
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

--select * from "Artist" a;

update "Artist" 
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

-------------------------------------------------------------------
--2.5

select *
from "Invoice" i 
where "BillingAddress" 
like 'T%';

----------------------------------------------------------
--2.6

select *
from "Invoice" i 
where "Total" 
between 15 and 20;

select * 
from "Employee" e
where "HireDate" 
between '01 Jun 2003' and '01 Mar 2004';

----------------------------------------------------------------
--2.7
/*
delete from "InvoiceLine" 
where "InvoiceId" in (
					select "InvoiceId"
					from "Invoice"
					where "CustomerId" in (
										 select "CustomerId"
										 from "Customer"
										 where "FirstName" = 'Robert' and "LastName" = 'Walter'));


delete from "InvoiceId"
where "CustomerId" in (
		   			select "CustomerId"
					from "Customer"
					where "FirstName" = 'Robert' and "LastName" = 'Walter');
					
delete from "CustomerId"
where "FirstName" = 'Robert' and "LastName" = 'Walter'

*/

alter table "InvoiceLine" drop
constraint "FK_InvoiceLineInvoiceId";

alter table "InvoiceLine" add
constraint "FK_InvoiceLineInvoiceId"
foreign key ("InvoiceId")
references "Invoice" ("InvoiceId")
on delete cascade;

alter table "Invoice" drop
constraint "FK_InvoiceCustomerId";

alter table "Invoice" add
constraint "FK_InvoiceCustomerId"
foreign key ("CustomerId")
references "Customer" ("CustomerId")
on delete cascade;

delete from "Customer" 
where "FirstName" = 'Robert' and "LastName" = 'Walter';

--**************************************************************
--3.0
--3.1

select now();

select "MediaTypeId", length("Name") as length_of_name
from "MediaType" mt;

--------------------------------------------------------------
--3.2

select avg("Total") as average_total_of_invoices
from "Invoice" i;

select *
from "Track" t
where "UnitPrice" = (
select max("UnitPrice")
from "Track"); 

-------------------------------------------------------------
--3.3

create or replace function avg_price_invoice_line()
returns numeric(10,2) 
as $$
	declare 
		average numeric;

	begin 
		select avg("UnitPrice")
		into average
		from "InvoiceLine";
	
		return average;
	end
$$language plpgsql;

select avg_price_invoice_line();

--------------------------------------------------------------
--3.4

drop function employees_born_after_1968();

create or replace function employees_born_after_1968()
returns table (
	firstname varchar, 
	lastname varchar, 
	birthdate timestamp)
as $$

	begin
		
		return query 
			select "Employee"."FirstName", "Employee"."LastName", "Employee"."BirthDate"
			from "Employee"
			where "BirthDate" >= '01 Jan 1969';
		
	end
$$ language plpgsql;



select * from employees_born_after_1968();

--**********************************************************************************
--4.0
--4.1

select i."InvoiceId", c."FirstName", c."LastName"
from "Customer" c 
inner join "Invoice" i 
on c."CustomerId" = i."CustomerId";

------------------------------------------------------------------------------------
--4.2

select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total"
from "Customer" c
full outer join "Invoice" i 
on c."CustomerId" = i."CustomerId";

-------------------------------------------------------------------------------------
--4.3

select art."Name", alb."Title"
from "Album" alb 
right join "Artist" art 
on art."ArtistId" = alb."ArtistId";

-------------------------------------------------------------------------------------
--4.4

select *
from "Album" alb
cross join "Artist" art 
order by art."Name" asc;

--------------------------------------------------------------------------------------
--4.5

select *
from "Employee" e1
join "Employee" e2
on e1."ReportsTo" = e2."EmployeeId";


























