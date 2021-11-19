----REVATURE ASSOCIATE SQL WORKBOOK---- 
----PART 1: WORKING WITH AN EXISTING DATABASE----

----2.1 SQL SELECT----
select * from "Employee" e;
select * from "Employee" where "LastName" = 'King';
select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" = null;--no result?

----2.2 ORDER BY----
select * from "Album" order by "AlbumId" desc;
select "FirstName" from "Customer" order by "FirstName" asc; 

----2.3 INSERT INTO----
insert into "Genre" ("GenreId", "Name") values ('26', 'Trap');
insert into "Genre" ("GenreId", "Name") values ('27', 'Spongebob Music');

----2.4 UPDATE----
update "Customer" 
set "FirstName" = 'Robert', "LastName" = 'Walter' 
where "FirstName" = 'Aaron' and "LastName"  = 'Mitchell';
--TEST--select "FirstName", "LastName" from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter'

update "Artist" 
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

----2.5 LIKE----
select * from "Invoice" where "BillingAddress" like 'T';--no result?

----2.6 BETWEEN----
select * from "Invoice" where "Total" between 15 and 50;
select * from "Employee" where "HireDate" between '2003-06-01 00:00:00.000' and '2004-03-01 00:00:00.000';

---- 2.7 DELETE----

delete from "InvoiceLine" il 
where il."InvoiceId" in 
    (select "InvoiceId" from "Invoice" i
    where "CustomerId" = '32');

delete from "Invoice" 
where "CustomerId" = '32';

delete from "Customer" c 
where "FirstName" = 'Robert' and "LastName" = 'Walter';

----3.0 SQL FUNCTIONS----
----3.1 SYSTEM DEFINED FUNCTIONS----
select timeofday(); 
select length("Name") from "MediaType" mt 

----3.2 System Defined Aggregate Functions----
select avg("Total") from "Invoice" 
select max("UnitPrice") from "Track" ;

----3.3 User Defined Scalar Functions----

select * from "InvoiceLine" il;

create function avgLineItemPrice ()
returns numeric
language plpgsql
as
$$
declare 
	price numeric;
begin
	select avg("UnitPrice")
	into price
	from "InvoiceLine";
	
	return price;
end; 
$$;

select avgLineItemPrice();

----3.4 USER DEFINED TABLE VALUED FUNCTIONS----

select * from "Employee" e 

create function bornAfter1968()
	returns "Employee"
	language plpgsql
	as
	$$
	begin
		return * from "Employee" where "BirthDate" > '1968-01-01 00:00:00.000'; 
	end;
	$$;

---4.0 JOINS----
----4.1 INNER----
select "InvoiceId", "FirstName", "LastName"
from "Customer" c
inner join "Invoice" i
on c."CustomerId" = i."CustomerId"

----4.2 OUTER----
select * from "Invoice";
select * from "Customer" 

select "InvoiceId", "FirstName", "LastName","Total"
from "Customer" c 
full outer join "Invoice" i 
on c."CustomerId" = i."CustomerId" 

----4.3 RIGHT----
select * from "Artist" a ;
select * from "Album" ab;

select "Title", "Name"
from "Artist" ar
right join "Album" ab
on ar."ArtistId" = ab."AlbumId";

----4.4 CROSS JOIN----
select * from "Album" a ;
select * from "Artist" a2 

select "Name"
from "Artist" a 
cross join "Album" a2 
order by "Name" asc;

----4.5 SELF----
select * from "Employee" e 

select "ReportsTo"
from "Employee"







