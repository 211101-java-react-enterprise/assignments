-- SELECT

select * from "Employee";

select * from "Employee"
where "LastName" = 'King';

select * from "Employee"
where "FirstName" = 'Andrew' and "ReportsTo" = null;

-- ORDER BY

select * from "Album"
order by "Title" desc;

select "FirstName" from "Customer"
order by "FirstName";

-- INSERT INTO

insert into "Genre" ("Name")
values ('Country'), ('Bachata');

insert into "Employee" ("EmployeeId", "LastName", "FirstName")
values (9, 'Jones', 'Jenny'), (10, 'Blass', 'Bobby');

insert into "Customer" ("CustomerId", "FirstName", "LastName", "Email")
values
	(60, 'Jones', 'Jenny', 'jenny@email.com'),
	(61, 'Blass', 'Bobby', 'bobby@email.com');

-- UPDATE

update "Customer"
set "FirstName" = 'Robert', "LastName" = 'Walker'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

-- LIKE

select * from "Invoice"
where "BillingAddress" like 'T%'

-- BETWEEN

select * from "Invoice"
where "Total" between 15 and 50;

select * from "Employee"
where "HireDate" between '2003-06-01' and '2004-03-01';

-- DELETE

--delete from "InvoiceLine"
--where "InvoiceId" = (select "InvoiceId" from "Invoice" where "CustomerId" = (select "CustomerId" from "Customer"
--where "FirstName" = 'Robert' and "LastName" = 'Walker'));
--
--delete from "Invoice"
--where "CustomerId" = (select "CustomerId" from "Customer"
--where "FirstName" = 'Robert' and "LastName" = 'Walker');
--
--delete from "Customer"
--where "FirstName" = 'Robert' and "LastName" = 'Walker';

-- SYSTEM DEFINED FUNCTIONS

select current_time;

select length("Name") as "MediaTypeLength"
from "MediaType"

-- SYSTEM DEFINED AGGREGATE FUNCTIONS

select avg("Total") as "AverageTotal" from "Invoice";

select max("UnitPrice") as "MaxUnitPrice" from "Track";

-- USER DEFINED SCALAR FUNCTIONS

select avg("UnitPrice") as "AverageUnitPrice" from "InvoiceLine";

-- USER DEFINED TABLE VALUED FUNCTIONS

select * from "Employee"
where "BirthDate" > '1968-12-31';

-- INNER JOIN

select "FirstName", "LastName", "InvoiceId"
from "Customer"
inner join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId";

-- OUTER JOIN

select "FirstName", "LastName", "InvoiceId", "Total"
from "Customer"
left join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId";

-- RIGHT JOIN

select "Name", "Title"
from "Album"
right join "Artist" on "Album"."ArtistId" = "Artist"."ArtistId";

-- CROSS JOIN

select *
from "Album"
cross join "Artist"
order by "Name"

-- SELF JOIN

select *
from "Employee" "E1", "Employee" "E2"
where "E1"."ReportsTo" = "E2"."ReportsTo";
