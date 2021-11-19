/*
 * 
 * 
 * 
 * 
 * 
 * Hey Wezley, find my project 0 easter egg.
 * 
 * 
 * 
 * 
 * 
 */



-- 2.1 SELECT

select * from "Employee" e;

select * from "Employee" e where "LastName" = 'King';

select * from "Employee" e where
	"FirstName" = 'Andrew' and "ReportsTo" is null;


-- 2.2 ORDER BY

select * from "Album" a order by "Title" desc;

select "FirstName" from "Customer" c order by "FirstName" asc;

-- 2.3 INSERT INTO

select * from "Customer" c ;

insert into "Genre" ("GenreId", "Name") values (26, 'Snake Jazz');
insert into "Genre" ("GenreId", "Name") values (27, 'Banana Regae');

insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title",
"ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode","Phone", "Fax", "Email")
	values ('9', 'Gomez', 'Selena', 'IT Manager', 1 , '1992-07-22 00:00:00.000', '2021-11-18 00:00:00.000', '65 Waverly Place', 'New York City',
	'NY', 'USA', '10023', '+1 (718) 420-1337', '+1 (212) 000-0000', 'selenaG@gmail.com');
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title",
"ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode","Phone", "Fax", "Email")
	values ('10', 'Nguyen', 'Tommy', 'IT Manager', 1 , '1996-08-25 00:00:00.000', '2021-11-18 00:00:00.000', '65 Waverly Place', 'New York City',
	'NY', 'USA', '10023', '+1 (718) 420-1337', '+1 (212) 000-0000', 'tommyN@gmail.com');
	
insert into "Customer" 
values ('60', 'Derrick', 'Sweeney', null, '123 AppleBee St.', 'Resturant City', 'VA', 'USA', '22032', null, null, 'dSweens@gmail.com', 3);
insert into "Customer" 
values ('61', 'Devin', 'Weeney', null, '124 AppleBee St.', 'Resturant City', 'VA', 'USA', '22032', null, null, 'dWeen@gmail.com', 3);

-- 2.4 UPDATE

update "Customer"
set "FirstName" = 'Robert Walter'
where "FirstName" ='Aaron Mitchell';

update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater';

-- 2.5 LIKE

select * from "Invoice" i where "BillingAddress" like 'T%';

-- 2.6 BETWEEN

select * from "Invoice" i where "Total" between 15 and 50;

select * from "Employee" e where "HireDate" between '2003-6-1 00:00:00' and '2004-1-3 00:00:00';

-- 2.7 DELETE

delete from "Customer" where "FirstName" = 'Robert Walter';

------------------------------------------------------------------------------------------------

-- 3.1 System Defined Functions

select current_time;

select char_length("Name") as lengthofMediaType 
from "MediaType" mt ;

-- 3.2 System Defined Aggregate FUnctions

select avg("Total") as avg_total
from "Invoice" i;

select max("UnitPrice") as most_expensive
from "Track" t;

-- 3.3 User Defined Scalar Functions

select avg("UnitPrice") as avg_price
from "InvoiceLine" il;

-- 3.4 User Defined Table Valued Function

select * from "Employee" e where "BirthDate" > '01/01/1968';

-- 4.1 INNER

select a."FirstName", b."InvoiceId" from "Customer" as a
inner join "Invoice" b on a."CustomerId" = b."CustomerId";

-- 4.2 OUTER

select c."CustomerId", c."FirstName" , c."LastName" , i."InvoiceId", i."Total"
from "Customer" c 
full join "Invoice" i on c."CustomerId" = i."CustomerId";

-- 4.3 RIGHT

select a2."Name" , a."Title" 
from "Album" a 
right join "Artist" a2 on a."ArtistId" = a."ArtistId";

-- 4.4 CROSS

select a."Name", a2
from "Artist" a 
cross join "Album" a2 order by a."Name" asc;

-- 4.5 SELF
 
select e2."FirstName", e2."LastName", e2."ReportsTo", e."FirstName", e."LastName"
from  "Employee" e , "Employee" e2
where e2."ReportsTo" = e."EmployeeId";