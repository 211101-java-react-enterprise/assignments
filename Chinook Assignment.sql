select * from "Employee" e 

select * from "Employee" e2 where "LastName" = 'King' 

select * from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" = null 
select * from "Album" l order by "Title" desc 

select * from "Album" l order by "Title" 

INSERT INTO public."Genre" ("GenreId","Name")
	VALUES (26,'JPop');
INSERT INTO public."Genre" ("GenreId","Name")
	VALUES (27,'Kpop');

INSERT INTO public."Employee" ("EmployeeId","LastName","FirstName","Title","ReportsTo","BirthDate","HireDate","Address","City","State","Country","PostalCode","Phone","Fax","Email")
	VALUES (9,'Robinson','Dario','Software Developer',6,'1996-09-20 00:00:00.000','2021-11-01 00:00:00.000','1129 Kenton Dr','Monterey Park','CA','United States','91755','+1 (626) 378-7204','+1 (626) 378-7110','dariorobinson12@gmail.com');
INSERT INTO public."Employee" ("EmployeeId","LastName","FirstName","Title","ReportsTo","BirthDate","HireDate","Address","City","State","Country","PostalCode","Phone","Fax","Email")
	VALUES (10,'Makunouchi','Ippo','Boxer',9,'1973-11-23 00:00:00.000','2021-11-01 00:00:00.000','1129 Kenton Dr','Monterey Park','CA','United States','91755','+1 (626) 378-0403','+1 (626) 378-0503','ippomakunouchi@gmail.com');

INSERT INTO public."Customer" ("CustomerId","FirstName","LastName","Address","City","State","Country","PostalCode","Phone","Email","SupportRepId")
	VALUES (60,'Dario','Robinson','1129 Kenton Dr','Monterey Park','CA','United States','91755','+1 (626)-378-7204','dariorobinson12@gmail.com',3);
INSERT INTO public."Customer" ("CustomerId","FirstName","LastName","Address","City","State","Country","PostalCode","Phone","Email","SupportRepId")
	VALUES (61,'Miyata','Ichiro','1129 Kenton Dr','Monterey Park','CA','United States','91755','+1 (626)-800-1000','ichiromiyata@gmail.com',3);

UPDATE public."Customer"
	SET "FirstName"='Robert',"LastName"='Walter'
	WHERE "CustomerId"=32;

UPDATE public."Artist"
	SET "Name"='CCR'
	WHERE "ArtistId"=76;

select * from "Invoice" i where "BillingAddress" like 'T%'

select * from "Invoice" i2 where "Total" between 15 and 50

select * from "Employee" e where "HireDate" between '2003-06-01 00:00:00.000' and '2004-03-01 00:00:00.000'


DELETE FROM public."Customer"
	WHERE "CustomerId"=32;

select current_timestamp 


select 
	"Name",
	Length("Name")
from 
	"MediaType" mt 
	

select avg("Total") as Avg_Total from "Invoice" i

select * from "Track" where "UnitPrice" =(select max("UnitPrice") from "Track" t)

select * from "InvoiceLine" il 

select avg("UnitPrice") as Avg_UnitPrice from "InvoiceLine" il 

select * from "Employee" e 

select * from "Employee" e where "BirthDate" > '1968-12-31'


select "FirstName", "LastName", "InvoiceId" 
from "Customer" 
inner join "Invoice"
on Customer."Address" = Invoice."BillingAddress" 

select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total" 
from public."Customer" c 
full outer join public."Invoice" i on c."CustomerId" = i."CustomerId";

select Album."Title", Artist."Name" 
from "Album" a 
right join "Artist" a2 using ("ArtistId")

select Album, Artist
from "Album" a 
cross join "Artist" a2 

select e1."FirstName", e1."LastName", e1."Title", e2."FirstName", e2."LastName", e2."Title"
from "Employee" e1
join "Employee" e2
on e1."ReportsTo" = e2."EmployeeId";