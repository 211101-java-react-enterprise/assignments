# Revature Associate SQL Workbook
 
## Part I – Working with an existing database

### 1.0 Setting up Chinook

In this section you will begin the process of working with the Chinook database

Task – Set up the Chinook DB by executing the script found [here](https://raw.githubusercontent.com/lerocha/chinook-database/master/ChinookDatabase/DataSources/Chinook_PostgreSql.sql)

### 2.0 SQL Queries
In this section you will be performing various queries against the PostgreSQL Chinook database.

### 2.1 SELECT
Task – Select all records from the Employee table. 
select * from "Employee" e;

Task – Select all records from the Employee table where last name is King.
select * from "Employee" e
where e."LastName" = 'King';

Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is null.
select * from "Employee" e
where e."FirstName" = 'Andrew' and e."ReportsTo" is null

### 2.2 ORDER BY
Task – Select all albums in album table and sort result set in descending order
select * from "Album" a
order by a."AlbumId" desc 

Task – Select first name from Customer and sort result set in ascending order
select "FirstName" from "Customer" c 
order by "FirstName"

### 2.3 INSERT INTO
Task – Insert two new records into Genre table
insert into "Genre" ("GenreId", "Name")
values
	('26', '26th genre'),
	('27', '27th genre');

Task – Insert two new records into Employee table
insert into "Employee" 
values
	('9', 'Tran', 'Danh', 'IT Staff', '6', '1998-07-02', CURRENT_TIMESTAMP, 'address', 'city', 'state', 'country', 'postcode', '1 (678) 678-6789', '1 (403) 403-4030', 'danh.tran@revature.net'),
	('10', 'Singleton', 'Wezley', 'Trainer', '1', '1970-01-01', CURRENT_TIMESTAMP, 'revature address', 'city', 'VA', 'US', 'postcode', '1 (123) 123-1234', '1 (123) 123-1234', 'wsingleton@revature.net');

Task – Insert two new records into Customer table
select * from "Customer" c ;
insert into "Customer" 
values
	('60', 'Danh', 'Tran', 'Revature', 'Virginia address', 'city', 'VA', 'US', '3000', '1 (678) 678-6789', '1 (403) 403-4030', 'danh.tran@revature.net', '3'),
	('61', 'Wezley', 'Singleton', 'Revature', 'Virginia Address', 'Virginia City', 'VA', 'United States', '30000', '1 (123) 123-1234', '1 (123) 123-1234', 'wsingleton@revature.net', '3');

### 2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
select * from "Customer" c
update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter'
where "FirstName" = 'Aaron';

Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
select * from "Artist" a where "ArtistId" = '76'
update "Artist" set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

### 2.5 LIKE
Task – Select all invoices with a billing address like “T”
select * from "Invoice" i
where i."BillingAddress" like 'T%'

### 2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
select * from "Invoice" i
where i."Total" between '15' and '50';

Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from "Employee" e 
where e."HireDate" between '2003-06-01' and '2004-03-01'

### 2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

delete from "InvoiceLine" il 
where il."InvoiceId" in 
	(select "InvoiceId" from "Invoice" i
	where "CustomerId" = '32'
	)
;

delete from "Invoice" 
where "CustomerId" = '32';

delete from "Customer" c 
where "FirstName" = 'Robert' and "LastName" = 'Walter';

### 3.0 SQL Functions
In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database

### 3.1 System Defined Functions
Task – Create a query that leverages a system-defined function to return the current time.
select CURRENT_TIME

Task – Create a query that leverages a system-defined function to return the length of a mediatype from the mediatype table;
select * from "MediaType" mt2 
select * from "Track" t ;
select "Name", length("Name") as length_of_name from "MediaType" mt 

### 3.2 System Defined Aggregate Functions
Task – Create a query that leverages a system-defined function to return the average total of all invoices
select avg("Total") from "Invoice" i 

Task – Create a query that leverages a system-defined function to return the most expensive track
select MAX("UnitPrice") from "Track" t 

### 3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoice-line items in the invoice-line table

create or replace function avgPriceOfInvoiceLine ()
returns numeric
language plpgsql
as
$$
	declare
	avg_invoice_price numeric;
	begin
		select avg("UnitPrice")
		into avg_invoice_price
		from "InvoiceLine";
		
		return avg_invoice_price;
	end
$$

select avgPriceOfInvoiceLine()

### 3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.

create or replace function employee_born_starting_from_year (year varchar)
returns table 
			(
			employee_id int,
			last_name varchar,
			first_name varchar,
			title varchar,
			reports_to int,
			birth_date timestamp,
			hire_Date timestamp,
			address varchar,
			city varchar,
			state varchar,
			country varchar,
			postal_code varchar,
			phone varchar,
			fax varchar,
			email varchar
			)
language plpgsql
as
$$
	begin
		
		return query
		select * from "Employee" e where e."BirthDate" > to_date(year, 'YYYY');
	end
$$

select * from employee_born_starting_from_year('1969');

### 4.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

### 4.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

select c."FirstName" || ' ' || c."LastName" as name , i."InvoiceId" from "Customer" c 
join "Invoice" i on c."CustomerId" = i."CustomerId" 

### 4.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.

select c."CustomerId" , c."FirstName" , c."LastName" , i."InvoiceId" , i."Total" from "Customer" c 
full outer join "Invoice" i on c."CustomerId" = i."CustomerId";

### 4.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.

select a2."Name" , a."Title" from "Album" a 
right join "Artist" a2 on a."ArtistId" = a2."ArtistId" ;

### 4.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

select * from "Album" a 
cross join "Artist" a2
order by a2."Name" asc;

### 4.5 SELF
Task – Perform a self-join on the employee table, joining on the reports to column.

select *
from "Employee" e1, "Employee" e2
where e1."ReportsTo" = e2."EmployeeId" 

select * from "Employee" e1
join "Employee" e2 on e1."ReportsTo" = e2."EmployeeId" 

