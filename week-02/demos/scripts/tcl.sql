/*
 * TCL (Transaction Control Language)
 * 
 * This is one of our 5 SQL sublanguages (DDL, DML, DQL, DCL, TCL)
 * 
 * A Transaction is a series of DML Statements (INSERT, UPDATE, SELECT, DELETE) executed together as one 
 * block of statements. A Transaction is all-or-nothing either every change goes through or none of them do
 * 
 * ACID Properties 
 * (A)tomicity -> All or nothing, either the entire transaction completes or gets aborted
 * (C)onsistency -> This states the database schema will remain intact during transactions
 * (I)solation -> This means every transactions happens separately from all other transactions
 * (D)urability -> After a transaction commits, it is persisted even in the even of a system failure
 * 
 * Why might we want to do this? If you have a series of DML statements that need to be executed but any
 * one of them can go wrong and leave the db in a incosistent or incorrect position we want to use a 
 * transaction
 * 
 * Example: Bank Transfer
 * Let's imagine I'm transferring $1000 from account A to account B. A Transfer involves withdrawing the
 * money from account A and depositing the money in account B. Imagine we withdraw the money from account 
 * A but the deposit steps fails for whatever reason. Using a transaction allow this to be handled by
 * rolling back the database to before the transfer ever started
*/

CREATE TABLE mytable(
	id int PRIMARY KEY,
	field_1 varchar(100),
	field_2 int
);

-- To Start a transaction we'll use the BEGIN keyword
BEGIN;

-- Next, let's add in some DML statements
INSERT INTO mytable VALUES (1, 'HELLO', 2);
INSERT INTO mytable VALUES (2, 'WORLD', 2);
INSERT INTO mytable VALUES (3, 'THIS IS A TRANSACTION', 2);

-- A SAVEPOINT can be created and we can roll back to it in the event of any issues
SAVEPOINT a;

-- Let's try to add a line that throws an error
-- At this point the changes as cached so if I run a select statement we'll see what happens
SELECT * FROM mytable;

-- Duplicate primary key
INSERT INTO mytable VALUES (1, 'HELLO AGAIN', 2);

-- ROLLBACK to a specific savepoint
ROLLBACK TO a;

-- If I want the results to saved to the database
-- I need to use the COMMIT keyword
COMMIT;

-- USED FOR CLEANING UP THE TABLE
TRUNCATE TABLE mytable;





