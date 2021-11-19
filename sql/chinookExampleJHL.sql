-- Chinook workbook script


-- SELECTS
select * from "Employee";

select * 
from "Employee" 
where "LastName" = 'King'; -- "" to denote name of column. '' to denote string

select *
from "Employee" 
where "ReportsTo" is Null -- null specifically must be checked with 'is'
and "FirstName" = 'Andrew';

-- Order By
select * 
from "Album" 
order by "AlbumId" desc ;

select "FirstName" 
from "Customer" 
order by "FirstName" asc;

-- Insert Into
insert into "Genre" ("GenreId", "Name") values (26 , 'Nightcore') , (27, 'Synthwave');

insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values 
(9, 'Smith', 'John', 'Janitor', 1, '1999-05-23', '2015-01-17', '1337 epic lane', 'Georgetown', 'Texas', 'USA', '13370', '+1 (234)-567-7890', null, 'hotvacuums@hotmail.com') ,
(10, 'Timo', 'Iswoman', 'Musician', 9, '1987-06-25', '2015-01-17', '1337 epic lane', 'Georgetown', 'Texas', 'USA', '13370', '+1 (098)-765-4321', null, 'email@google.com');

insert into "Customer" 
("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode","Phone", "Fax", "Email", "SupportRepId")
values
(60, 'Poggy', 'Chat', null, '420 sadge blvd', 'Pepega', 'Arkansas', 'USA', '85421', '+1 (839) 521-8976', null, 'wow@mail.com', 3),
(61, 'MonkaS', 'Awooga', null, '587 bruh st', 'Heii', 'West Virginia', 'USA', '45127', '+1 (542) 124-9875', null, 'suchislife@gmail.com', 4);

-- update 
update "Customer" 
set "FirstName" = 'Robert',"LastName" = 'Walter'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

update "Artist" 
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

-- Like
select *
from "Invoice" 
where "BillingAddress" like 'T%'

-- Between
select *
from "Invoice" 
where "Total" between 15 and 50;

select *
from "Employee" 
where "HireDate" between '2003-06-01' and '2004-04-01';

-- delete 

select "CustomerId" a from "Customer" where
"FirstName" = 'Robert' and 
"LastName" = 'Walter';

-- results in 50, 61, 116, 245, 268, 190, 342
select "InvoiceId" from "Invoice" where 
"CustomerId" = 32;

delete from "InvoiceLine" where 
"InvoiceId" = 50 or 
"InvoiceId" = 61 or 
"InvoiceId" = 116 or 
"InvoiceId" = 245 or 
"InvoiceId" = 268 or 
"InvoiceId" = 290 or 
"InvoiceId" = 342;

delete from "Invoice" where 
"CustomerId" = 32;

delete from "Customer" where 
"FirstName" = 'Robert' and 
"LastName" = 'Walter';

-- Functions

-- System Defined Functions

-- Current time
select current_timestamp;
-- Mediatype length from "MediaType" table
select length("Name") from "MediaType";

-- System Defined Aggregate Functions
-- Average
select avg("Total") from "Invoice";


select *
from "Track" a
where "UnitPrice" = (select max("UnitPrice") from "Track" b )


-- User Scalar Functions
create or replace function invoiceAvg ()
returns numeric(6,2)
as $$
	declare 
		totSum numeric(8,2);
		amt int;
		product numeric(8,2);
	begin 
		select sum("UnitPrice") into totSum from "InvoiceLine";
		select max("InvoiceLineId") into amt from "InvoiceLine";
		select totSum / amt into product;
		return product;
	end
$$ language plpgsql;

select invoiceAvg();

-- User Table Valued Functions
create or replace function cantCook()
returns setof "Employee"
as $$
	begin
		return query
		select * 
		from "Employee"
		where "BirthDate" > '1968-01-01';
	end
$$ language plpgsql;

select cantCook();

-- Joins

-- INNER Join
-- join customers and orders and specify the name of the customer and invoice id
select  "Invoice"."InvoiceId", "Customer"."FirstName", "Customer"."LastName"
from "Customer" 
inner join "Invoice"  on "Invoice"."CustomerId" = "Customer"."CustomerId" ;

-- Outer Join
-- Outer join customer and invoice. Specify id, first name, last name, invoice id, and total
select "Customer"."CustomerId", "Customer"."FirstName", "Customer"."LastName" , "Invoice"."InvoiceId", "Invoice"."Total"
from "Customer" 
full outer join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId"
where "Customer"."CustomerId" = "Invoice"."CustomerId";

-- Right join
-- Join album and artist with artist name and title
select "Album"."Title", "Artist"."Name"
from "Album"
right join "Artist" 
on "Album"."ArtistId" = "Artist"."ArtistId";


-- Cross join
-- Join album and artist and sort by artist name in ascending order...
select "Album".*, "Artist".*
from "Album" 
cross join "Artist" 
order by "Artist"."Name" asc;

-- Self join
-- Self join on employee table, joining on reports to...
select e1.*, e2.*
from "Employee" e1, "Employee" e2
where e1."ReportsTo" = e2."EmployeeId";
