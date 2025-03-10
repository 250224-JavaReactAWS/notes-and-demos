# SQL Overview

What is a database?

-   A collection of structured data, typically grouped into tables
-   Each table has rows and columns
    -   The row will hold the information about the particular entry
    -   The columns are are attributes of the items in the table

Every table will have a primary key:

-   A unique identifier for each entry in the database
-   Each row will have only one primary key, but a primary key can consist of multiple columns (composite key)

## DBMS and RDBMS

DBMS: Database Management System

-   These are what we use to store and manage the data in our databases

RDBMS: Relational Database Management System

-   This is what we will be using during training
-   Relational Databases are used to store information in tables that have relations with one another
-   RDBMS's are structured so that it maintains the security, accuracy, integrity, and consistency of data
-   The ultimate goals of a Database is to persist information

## SQL

SQL: Structured Query Language

-   This is not a programming language
-   It is the underlying language used to query relational databases
-   English like syntax for developers to manipulate data

# Database Vendors

There are many different RDBMS vendors / flavors of SQL, these include:
- Oracle
- PostregreSQL
- MySQL
- Microsoft SQLServer
- Microsoft Access

We will be focusing on PostgreSQL during training

# Data Types

Tables in our databases have attributes that describe the data stored in the row, these attributes can be of many different data types. Here is a list of common data types, and a link to the official documentation with all of the data types:

-   boolean (bool): evaluates to true or false
-   character (`char[n]`) : a fixed length character string
-   character varying (`varchar[n]`) : a varying length string of characters
-   date : a calendar date
-   integer (int): a whole number
-   numeric/decimal: a decimal number

PostgreSQL documentation on data types:

https://www.postgresql.org/docs/9.5/datatype.html

# Schema

A database schema refers to the formal structure of data defined by a relational database, this includes:
- the various tables in the database and their columns and data types
- the relationships between tables in the database

Schemas enforce constraints when defining tables, so we can visualize them through Entity Relationship Diagrams

An Entity Relationship Diagram illustrates how different tables in a database relate to one another

<img src = "https://landing.moqups.com/img/content/diagrams/erd/database-diagram/database-diagram-1600.png" width = "600">

They contain three main components:

The entity:
- What the table is representing

Attributes:
- These are the columns of the table

Relationships
- These are the connections between the tables

# Multiplicity in Databases

Multiplicity is the relationship between entries in different tables

These relationships are defined with foreign key constraints

Foreign Keys:

-   Make relations between tables
-   Do not need to be unique, but can be
-   Can be made up of one or more columns

There are four types of multiplicity in relational databases

1. One-to-many: one entry in the first table can be mapped to many entries in the second table
    - The foreign key in the first is allowed to map to multiple entries in the second table
2. Many-to-one: this is the opposite of the above
3. Many-to-many: Many entries of the first table can be mapped to many entries in the second table
    - These are implemented with what are called junction tables
4. One-to-one: a single entry in the first table is mapped to a single entry in the second table
    - The foreign key of both tables must be unique

## Referential Intregrity

-   A foreign key is the reference to the relationship in multiplicity, and the rule ensures that a referenced record always exists
-   You are not allowed to delete an entry if an entry of another table depends on it
-   You can use cascade on delete, which will delete children and parent entries

# SQL Sublanguages

There are 4 or 5 sublangauges in SQL depending on who you ask

-   In this training we say their are 5 regardless of the debate

## Data Definition Language (DDL):

-   Used to define the database itself
-   Deals with creation, alteration, or deletion or tables, schemas, or databases themselves
-   Syntax/Keywords for the DDL:
    -   `CREATE`: used to create a new table, schema, or database
    -   `ALTER`: used to make changes to a table, schema, or database
    -   `DROP`: used to completely remove/delete a table
    -   `TRUNCATE`: used to remove all the data from a table, but leave it's structure behind

## Data Manipulation Language (DML):

-   Used to change data inside of the database
-   Often referred to as the CRUD operations (Create, Read, Update, Delete)
    -   This is the theoretical construct of what you should be able to do with data in a table
-   Syntax/Keywords for the DML:
    -   `INSERT` : used to add new data into a table
    -   `SELECT`: used to retrieve data from a table
    -   `UPDATE` : used to make a change to existing data in a table
    -   `DELETE` : used to remove a record from a table

## Data Query Language (DQL):

-   This one is often debated, however it exists in Postgres so we teach it
-   The debate itself is whether it should be its own sublanguage, or a sublanguage of DML
-   Syntax/Keywords for DQL:
    -   `SELECT`: used to retrieve data from a table
-   Typically DQL is referring to when we use constraints aka the `WHERE` clause

### Query clauses

`SELECT` [columns]

`FROM` [table]

`WHERE` [condition] -- filters pre aggregation if aggregation is occurring

`GROUP BY` [column] -- defines how our data is going to be aggregated

`HAVING` [condition] -- filters after aggregation

`ORDER BY` [column][asc/desc]


## Data Control Language (DCL)

-   This sublanguage is used to manage the security and control of our database
-   Syntax/Keywords for DCL:
    -   `GRANT`: to grant any permissions to a user
    -   `REVOKE`: to remove ant permissions from a user

## Transaction Control Language (TCL)

-   Used to manage transactions within the database (more on this later)
-   Syntax/Keywords for TCL:
    -   `COMMIT`: this will permanently save any DML operations that occurred
    -   `ROLLBACK`: this will completely erase any DML operations that occurred between two commits. Keep in mind, once you commit changes you cannot rollback
    -   `SAVEPOINT`: creates a spot to rollback to

# Constraints

Constraints are restrictions that we can put on the columns of our tables in SQL

Some constraints in SQL include:

-   Composite keys: a key that uses more than one column
-   Not null: the column must have data
-   Unique: no two records entered into this column can be the same
-   Primary key: denotes that this column is a primary key
-   Foreign key: denotes that this column is pointing to an attribute on another table
-   Default: creates a default value if none is given

# Aggregate and Scalar Functions

Aggregate functions take multiple rows, and combine the values into one single column

Some popular aggregates functions are as follows:

-   MAX(Column): returns the max value of that column
-   MIN(Column): returns the min value of that column
-   AVG(Column): returns the average value of that column
-   SUM(Column): adds and returns the sum of the values in the column
-   COUNT(column): returns the number of elements in that column

These function are used in the SELECT clause, and cannot be used with the WHERE clause

If more than one column is being selected in the SELECT column section of the query, a GROUP By is required

You can use the HAVING clause with an aggregate function instead of WHERE

Scalar functions operate on a single row, these can be used with SELECT and WHERE

Some popular scalar functions are as follows:

-   LENGTH(string): returns the length of a string in the given row
-   UPPER(string): returns the string in upper case
-   LOWER(string): returns the string in lower case
-   ABS(num): returns the absolute value of the row
-   CEILING(num): returns the rounded up number
-   FLOOR(num): returns the rounded down number

# Acid Properties

In SQL every transaction must have a specific four properties, these are know as the ACID properties

**Atomic:** All or nothing, the transaction is fully completed, or it doesn't happen at all

**Consistency:** The tables schema will remain intact after the transaction

**Isolation:** Each transaction cannot affect the results of another transaction

**Durability:** Data will persist through system crashes and other issues

