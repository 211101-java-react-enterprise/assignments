--2.1
select * from "Employee" e ;
select * from "Employee" e where "LastName" = 'King';
select * from "Employee" e where "FirstName" = 'Andrew' and "ReportsTo" is null;


--2.2
select * from "Album" a;
select * from "Album" a order by "AlbumId" desc;
select * from "Customer" c order by "CustomerId" asc;

--2.3
select * from "Genre" g;
select * from "Customer" c;
insert into "Genre" ("GenreId", "Name") values (26, 'Cover' ), (27, 'Test');
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values 				   ('9', 'A', 'B', 'C', '1', '1950-01-01', '1990-01-01', 'Address', 'Seattle', 'WA', 'USA', '98225', '+1 (425) 555-5555', '+1 (425) 555-5556', 'A@gmail.com'),
					   ('10', 'B', 'B', 'C', '1', '1950-01-01', '1990-01-01', 'Address', 'Seattle', 'WA', 'USA', '98225', '+1 (425) 555-5555', '+1 (425) 555-5556', 'A@gmail.com');

INSERT into "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
values (60, 'A', 'A', 'Company', 'A', 'A', 'A', 'A', '1234', 'no', 'fax#', 'emailz', 3),
	   (61, 'B', 'A', 'Company', 'A', 'A', 'A', 'A', '1234', 'no', 'fax#', 'emailz', 3)	;
	  
  --2.4
select * from "Customer" c;
select * from "Artist" a order by "Name" asc;
update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter' where "CustomerId" = 32;
update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';

--2.5
select * from "Invoice";
select * from "Invoice" i where "BillingAddress" like 'T%';

--2.6
select * from "Invoice" i;
select * from "Invoice" i where "Total" between '15' and '50';
select * from "Employee" e where "HireDate" between '2003-06-01%' and '2004-03-01%';

--2.7
select * from "Customer" c;
select * from "Invoice" i where "CustomerId" = 32;
select * from "Customer" c where "CustomerId" = 32;
select * from "InvoiceLine" il where "InvoiceId" = 50;
delete from "InvoiceLine" where "InvoiceId" = 50;
delete from "InvoiceLine" where "InvoiceId" = 61;
delete from "InvoiceLine" where "InvoiceId" = 116;
delete from "InvoiceLine" where "InvoiceId" = 245;
delete from "InvoiceLine" where "InvoiceId" = 268;
delete from "InvoiceLine" where "InvoiceId" = 290;
delete from "InvoiceLine" where "InvoiceId" = 342;
delete from "Invoice" where "CustomerId" = 32;
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';

--3.1
select current_time; 
select LENGTH("Name") as LengthOfType from "MediaType" mt;

--3.2
select avg("Total") as AverageOfTotal from "Invoice" i; 
select MAX("UnitPrice") as MostExpensive from "Track" t;
select * from "Track" t where "UnitPrice" = (select max("UnitPrice") from "Track" t2);

--3.3
create function averageInvoicePriceTest()
returns numeric(19,2)
as '
	declare 
		average_price numeric(10,2);
	
	begin
		--Get the average
	select avg("UnitPrice") into average_price from "InvoiceLine" i; 
	return average_price;
	end

' language plpgsql;

select averageInvoicePriceTest();

--3.4 
create function born_After_date2(d_m_y varchar)
returns table ("EmployeeId" int,s
				"LastName" varchar(20),
				"FirstName" varchar(30),
				"Title" varchar(30),
				"ReportsTo" int,
				"BirthDate" timestamp,
				"HireDate" timestamp,
				"Address" varchar(70),
				"City" varchar(40),
				"State" varchar(40),
				"Country" varchar(40),
				"PostalCode" varchar(10),
				"Phone" varchar (24),
				"Fax" varchar(24),
				"Email" varchar(60))
as $$
	
	begin
	return query
	select * from "Employee" e where e."BirthDate" > to_date(d_m_y, 'DD mon YYYY'); 
	
	end
$$ language plpgsql;

select born_After_date2('31 dec 1968');


--4.1
select * from "Customer" c inner join "Invoice" i on c."CustomerId" = i."CustomerId";

--4.2
select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total" from "Customer" c full outer join "Invoice" i on c."CustomerId" = i."CustomerId"; 

--4.3
select * from "Album" a right join "Artist" a2 on a."ArtistId" = a2."ArtistId";

--4.4
select * from "Album" a cross join "Artist" a2 order by a2."Name" asc;

--4.5
SELECT column_name(s)
FROM table1 T1, table1 T2
WHERE condition;

select * from "Employee" e, "Employee" e2 where e2."ReportsTo" = e."EmployeeId";

--Further Reserch
returns setof "Employee";
