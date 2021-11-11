# Revature Associate SQL Workbook
 
## Part I – Working with an existing database

### 1.0 Setting up Chinook

In this section you will begin the process of working with the Chinook database

Task – Set up the Chinook DB by executing the script found [here](https://raw.githubusercontent.com/lerocha/chinook-database/master/ChinookDatabase/DataSources/Chinook_PostgreSql.sql)

### 2.0 SQL Queries
In this section you will be performing various queries against the Oracle Chinook database.

### 2.1 SELECT
Task – Select all records from the Employee table. 

Task – Select all records from the Employee table where last name is King.

Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

### 2.2 ORDER BY
Task – Select all albums in album table and sort result set in descending order

Task – Select first name from Customer and sort result set in ascending order

### 2.3 INSERT INTO
Task – Insert two new records into Genre table

Task – Insert two new records into Employee table

Task – Insert two new records into Customer table

### 2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter

Task – Update name of artist “Creedence Clearwater Revival” to “CCR”

### 2.5 LIKE
Task – Select all invoices with a billing address like “T”

### 2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50

Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

### 2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).


### 3.0 SQL Functions
In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database

### 3.1 System Defined Functions
Task – Create a query that leverages a system-defined function to return the current time.

Task – Create a query that leverages a system-defined function to return the length of a mediatype from the mediatype table

### 3.2 System Defined Aggregate Functions
Task – Create a query that leverages a system-defined function to return the average total of all invoices

Task – Create a query that leverages a system-defined function to return the most expensive track

### 3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoice-line items in the invoice-line table

### 3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.

### 4.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

### 4.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

### 4.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.

### 4.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.

### 4.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

### 4.5 SELF
Task – Perform a self-join on the employee table, joining on the reports to column.


