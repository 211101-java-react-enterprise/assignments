-- 2.1 SELECT --
select * from chinook."Employee" e ;
select * from chinook."Employee" e where "LastName" ='King';
select * from chinook."Employee" e where "FirstName" ='Andrew' and "ReportsTo" is null;

select * from chinook."Album" a order by "Title" desc;
select "FirstName" from chinook."Customer" c order by "FirstName" ;

insert into chinook."Genre" values (26,'K-Drama');
INSERT INTO chinook."Employee" ("EmployeeId","LastName","FirstName","Title","ReportsTo","BirthDate","HireDate","Address","City","State","Country","PostalCode","Phone","Fax","Email") VALUES
	 (9,'Adams2','Andrew','General Manager',NULL,'1962-02-18 00:00:00','2002-08-14 00:00:00','11120 Jasper Ave NW','Edmonton','AB','Canada','T5K 2N1','+1 (780) 428-9482','+1 (780) 428-3457','andrew@chinookcorp.com'),
	 (10,'Edwards2','Nancy','Sales Manager',1,'1958-12-08 00:00:00','2002-05-01 00:00:00','825 8 Ave SW','Calgary','AB','Canada','T2P 2T3','+1 (403) 262-3443','+1 (403) 262-3322','nancy@chinookcorp.com');
INSERT INTO chinook."Customer" ("CustomerId","FirstName","LastName","Company","Address","City","State","Country","PostalCode","Phone","Fax","Email","SupportRepId") VALUES
	 (60,'Lu?s','Gon?alves','Embraer - Empresa Brasileira de Aeron?utica S.A.','Av. Brigadeiro Faria Lima, 2170','S?o Jos? dos Campos','SP','Brazil','12227-000','+55 (12) 3923-5555','+55 (12) 3923-5566','luisg@embraer.com.br',3),
	 (61,'Leonie','K?hler',NULL,'Theodor-Heuss-Stra?e 34','Stuttgart',NULL,'Germany','70174','+49 0711 2842222',NULL,'leonekohler@surfeu.de',5);

update chinook."Customer" set  "FirstName" = 'Robert', "LastName" ='Walter' where "FirstName" ='Aaron' and "LastName" ='Mitchell';
update chinook."Artist" set "Name" ='CCR' where "Name" ='Creedence Clearwater Revival';

select * from chinook."Invoice" i where "BillingAddress" like '%T%';

select * from chinook."Invoice" i where "Total" between 15 and 50;
select * from chinook."Employee" e where "HireDate" BETWEEN date('Jun-1-2003') and date('Mar-1-2004');

alter table chinook."Invoice"
drop constraint "FK_InvoiceCustomerId",
add CONSTRAINT "FK_InvoiceCustomerId" FOREIGN KEY ("CustomerId") REFERENCES chinook."Customer"("CustomerId")  on delete cascade;

alter table chinook."InvoiceLine"
drop constraint "FK_InvoiceLineInvoiceId",
add CONSTRAINT "FK_InvoiceLineInvoiceId" FOREIGN KEY ("InvoiceId") REFERENCES chinook."Invoice"("InvoiceId")  on delete cascade;

delete from chinook."Customer" where "FirstName" ='Robert' and "LastName" ='Walter';

SELECT NOW();

select length("Name") from chinook."MediaType";

select avg("Total") from chinook."Invoice";
select max("UnitPrice") from chinook."Track" t ;

create function function_jsc()
returns double precision
language plpgsql
as
$$
declare
   ave double precision;
begin
   select avg ("UnitPrice") 
   into ave
   from chinook."InvoiceLine"; 
   
   return ave;
end;
$$;

select function_jsc();

create or replace function getjsc (
  
) 
	returns setof chinook."Employee" 
	language plpgsql
as $$
begin
	return query 
		select
			e.*
		from
			chinook."Employee" e;
end;$$
;

SELECT * FROM getjsc() AS t1;

select c."FirstName" , c."LastName" , i."InvoiceId"  from "Customer" c left join "Invoice" i 
on c."CustomerId" = i."CustomerId" ;

select a2."Name" , a."Title" from "Album" a cross join "Artist" a2 
order by a2."Name" ;

select * from "Employee" e inner join "Employee" e2 on e."ReportsTo" = e2."EmployeeId" ;
