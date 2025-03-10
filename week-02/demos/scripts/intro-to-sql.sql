-- To write a comment in SQL use -- at the beginning of the line

-- SQL (Structured Query Language) is a query language designed to work with databases and
-- allow us to perform operations or queries against them
-- SQL databases stored data in related tables with rows and columns (relational database)
-- SQL is known for it's easy to use syntax and quick ability to learn
-- It's NOT a programming language
-- There are several sublanguages (5 in total)


-- CRUD Methods (Create, Read, Update, Delete)

-- Let's create our very first table and throw some info inside of it

-- Creating tables in SQL is part of the first sublanguage, DDL (Data Definition Language)
-- DDL is used to define, update, remove things from the database schema
-- Schema is word that refers to any structure inside the database, this can include tables, 
-- column, groups of tables, etc

CREATE TABLE people(
	-- The CREATE TABLE command allows us to create a table with the specified name
	-- Inside of the parantheses we will define all of our columns
	-- Every single column will have 3 pieces of info for it
	-- Name, Datatype, and any constraints on the data
	-- Every table in a SQL database should have a primary key
	-- A primary key is a unique identifier that allows us to access a specific record/row at any time
	person_id int PRIMARY KEY,
	first_name varchar(30),
	last_name varchar(30),
	age int,
	isMarried bool,
	height NUMERIC(5,2)
);

-- Datatypes In SQL
-- There's actually a LOT, we'll do our best to remember a small handful of them
-- int
-- (Strings) char (exact number of characters), varchar(varying number of characters), text 
-- bool
-- decimal/numeric



-- Let's Insert some people into our database table
-- CRUD methods this is C for creating data
INSERT INTO people VALUES (1, 'Terra', 'Dactyl', 24, FALSE, 150.51);
-- In SQL '' are used for Strings and "" are used for referring to columns

-- Insert multiple records
INSERT INTO PEOPLE VALUES 
(2, 'Kaitlyn', 'Graves', 27, TRUE, 170), 
(3, 'Dewey', 'Finn', 35, FALSE, 190.5);


-- Reading info from the table
-- R from CRUD (Read method)
-- SELECT
SELECT * FROM PEOPLE;

-- Select specific columns by name
SELECT first_name FROM people;

-- Select multiple columns
SELECT first_name, last_name FROM people;

-- Filtering using WHERE
SELECT * FROM PEOPLE WHERE isMarried = FALSE;




-- Sublanguages of SQL
-- Data Definition Language (DDL)
	-- Used to define Schema inside our database 
	-- Includes creating updating and deleting table/columns
	-- CREATE
	-- ALTER
	-- TRUNCATE
	-- DROP
-- Data Manipulation Language (DML)
	-- Used whenever we want to manipulate data in any way
	-- Directly associated with our CRUD methods
	-- INSERT
	-- SELECT
	-- UPDATE
	-- DELETE
-- Data Query Language (DQL)
	-- This sublanguage refers to all of the various clauses that can be used with a SELECT statement
	-- Some people label this as DML since it's all within a select statement
	-- WHERE
	-- HAVING
	-- GROUP BY
	-- ORDER BY
	-- BETWEEN
	-- LIKE
-- Data Control Language (DCL)
	-- Used for giving/revoking roles and responsibilities to database users
	-- GRANT
	-- REVOKE
-- Transaction Control Language (TCL)
	-- Transactions are a block of DML statements that get executed together in a block, TCL allows
	-- us to control how that block works
	-- COMMIT
	-- SAVEPOINT
	-- ROLLBACK














