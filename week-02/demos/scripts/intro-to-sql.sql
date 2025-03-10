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


-- Data Definition Language
-- CREATE
-- Creating new tables

CREATE TABLE pets(
	pet_id int PRIMARY KEY,
	name varchar(25),
	age int
);

-- ALTER
-- Altering tables (changing datatypes, names, or constraints)
-- Come back to this later
-- ALTER TABLE pets

-- Let's add in some records to test truncate and drop
INSERT INTO pets VALUES 
(1, 'Cash', 11),
(2, 'Mya', 15),
(3, 'Rex', 3);

-- TRUNCATE
-- Removes all of the data from the table (but leaves the table)
TRUNCATE TABLE pets;

-- DROP
-- Removes the table and all of its data
DROP TABLE PETS;
-- After running this the pets table is now gone

-- Constraints
-- Constraints are the third piece that comes in when defining a column
-- It constrains the data entered into that column
-- UNIQUE - Makes it so a value must be unique within a column
-- NOT NULL - Makes it so the value must exist and not be null
-- PRIMARY KEY - Combination of UNIQUE and NOT NULL, used as an identifier for the table
-- FOREIGN KEY - Used to reference another table
-- CHECK - Used to make sure the data passes some requirement
-- DEFAULT - Used to provide a default value

CREATE TABLE employees(
	-- employee_id int PRIMARY KEY,
	-- In PostgreSQL we can have the table AUTOMATICALLY determine a primary key by using the SERIAL datatype
	-- This is a subtype of int, so technically they're all ints
	-- Other vendors of SQL like MySQL, or SQL Server, use AUTO INCREMENT on their id columns for this
	employee_id serial PRIMARY KEY,
	name varchar(50) NOT NULL,
	email varchar(50) UNIQUE,
	age int CHECK (age > 0),
	is_manager bool DEFAULT false,
	salary NUMERIC(10,2) NOT NULL CHECK (salary > 0),
	location_state char(2) DEFAULT 'FL' -- char(2) means this MUST be 2 letters, NO MORE NO LESS
);

-- Test Some Constraints
INSERT INTO employees VALUES 
(1, 'Bryan', 'bryan.serfozo@revature.com', 27, TRUE, 50000.51, 'FL');

-- NULL NAME
INSERT INTO employees VALUES 
(2, NULL, 'bryan.serfozo2@revature.com', 27, TRUE, 50000.51, 'FL');
-- This doesn't work because the value of the name column is null when it's specifically marked as not null

-- NON-UNIQUE Email
INSERT INTO employees VALUES 
(3, 'Bryan', 'bryan.serfozo@revature.com', 27, TRUE, 50000.51, 'FL');
-- This doesn't work because email is marked as UNIQUE so it cannot be the same as a previous entry

-- PRIMARY KEY (Combo of UNIQUE and NOT NULL)
INSERT INTO employees VALUES 
(NULL, 'Bryan', 'bryan.serfozo2@revature.com', 27, TRUE, 50000.51, 'FL');
-- Doesn't work because PK is null
INSERT INTO employees VALUES 
(1, 'Bryan', 'bryan.serfozo3@revature.com', 27, TRUE, 50000.51, 'FL');
-- Emp id of 1 is already taken 


-- DEFAULT provides a value for a column if no value is provided
-- We can enter into specific columns only if we specify them
INSERT INTO employees (employee_id, name, email, age, salary) VALUES
(3, 'Terra', 'terra.dactyl@revature.com', 24,  60357.13);

-- CHECK checks against some specified criteria
-- BOTH age and salary need to be greater than 0 to add in this record
INSERT INTO employees (employee_id, name, email, age, salary) VALUES
(4, 'Terra', 'terra.dactyl2@revature.com', -24,  -60357.13);

-- SWITCHED TO SERIAL DATATYPE

INSERT INTO employees (name, email, age, salary) VALUES
('Terra 1', 'terra.dactyl@revature.com', 24,  60357.13),
('Terra 2', 'terra.dactyl2@revature.com', 24,  60357.13),
('Terra 3', 'terra.dactyl3@revature.com', 24,  60357.13);

DROP TABLE employees;


-- Data Manipulation Language (DML)
-- We've already seen INSERT and SELECT
-- Let's add in UPDATE and DELETE
-- But first, mock some data (mockaroo)


insert into employees (name, email, age, is_manager, salary, location_state) values ('Selene Harby', 'sharby0@noaa.gov', 20, true, 30049.44, 'FL');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Adelheid Simione', 'asimione1@paypal.com', 33, false, 52087.25, 'CA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Delores Clamo', 'dclamo2@irs.gov', 48, false, 32044.57, 'IA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Dido Ghilardini', 'dghilardini3@cnn.com', 60, true, 92557.2, 'AZ');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Carrissa Jackman', 'cjackman4@theatlantic.com', 37, true, 42373.83, 'NY');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Gwennie Rupert', 'grupert5@dagondesign.com', 34, false, 99043.83, 'AR');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Lonnard Livingstone', 'llivingstone6@time.com', 30, true, 40042.68, 'WA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Darryl Fawltey', 'dfawltey7@flavors.me', 52, true, 64265.43, 'TX');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Emmalee McKennan', 'emckennan8@yellowbook.com', 43, true, 58750.08, 'MI');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Tersina Tebbut', 'ttebbut9@independent.co.uk', 29, false, 47823.92, 'IL');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Noelyn Costan', 'ncostana@blinklist.com', 21, true, 40541.64, 'DC');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Anstice Ludlam', 'aludlamb@nps.gov', 38, true, 70483.54, 'NC');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Jobi Bonn', 'jbonnc@aol.com', 25, false, 42730.5, 'IN');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Saundra Stooders', 'sstoodersd@shop-pro.jp', 59, true, 31149.27, 'OH');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Newton Wagstaff', 'nwagstaffe@mozilla.org', 26, true, 87954.27, 'MN');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Morena Tommen', 'mtommenf@cnn.com', 51, false, 93392.76, 'OH');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Lovell Bigly', 'lbiglyg@bbc.co.uk', 43, false, 39140.53, 'CA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Jenifer Coils', 'jcoilsh@lulu.com', 21, true, 58210.99, 'OR');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Lucais MacParlan', 'lmacparlani@so-net.ne.jp', 36, false, 38798.41, 'PA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Karmen Christal', 'kchristalj@about.me', 27, false, 90929.86, 'FL');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Umeko Watman', 'uwatmank@bluehost.com', 47, true, 48649.65, 'IL');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Kendal Kimber', 'kkimberl@livejournal.com', 24, true, 32749.93, 'GA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Chester Belchem', 'cbelchemm@amazonaws.com', 42, true, 84827.73, 'CA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Joellyn Allmond', 'jallmondn@purevolume.com', 25, true, 31491.49, 'IN');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Bart Ezele', 'bezeleo@techcrunch.com', 42, false, 86328.0, 'NY');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Osbert Henrionot', 'ohenrionotp@wikispaces.com', 48, true, 88135.13, 'DC');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Hans Martinek', 'hmartinekq@phoca.cz', 46, true, 35881.14, 'OK');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Milt Hayball', 'mhayballr@blogtalkradio.com', 55, false, 60690.57, 'GA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Westley Bernetti', 'wbernettis@samsung.com', 57, false, 56401.76, 'OR');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Carly Graber', 'cgrabert@zimbio.com', 20, false, 79072.08, 'SC');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Zoe Palfery', 'zpalferyu@miibeian.gov.cn', 59, true, 98723.95, 'TX');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Rey Faudrie', 'rfaudriev@hhs.gov', 19, false, 91443.7, 'NM');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Paul Ribbon', 'pribbonw@ucla.edu', 58, true, 31857.88, 'PA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Willi De la Yglesias', 'wdex@harvard.edu', 37, false, 53609.18, 'MS');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Kevyn Bluschke', 'kbluschkey@yelp.com', 55, true, 75601.52, 'CA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Salim Mathen', 'smathenz@nba.com', 52, false, 93173.96, 'TX');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Patty Munsey', 'pmunsey10@sciencedirect.com', 29, false, 69236.31, 'WA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Shirl Fadden', 'sfadden11@digg.com', 35, false, 40989.91, 'ID');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Phedra Becks', 'pbecks12@netscape.com', 51, true, 48937.62, 'TX');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Cesar Tincknell', 'ctincknell13@yolasite.com', 40, true, 68185.72, 'FL');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Georgy Girardeau', 'ggirardeau14@linkedin.com', 42, false, 72432.38, 'OH');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Dody Blaschke', 'dblaschke15@howstuffworks.com', 21, true, 61170.69, 'CO');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Cathryn Hadgkiss', 'chadgkiss16@dell.com', 48, false, 48161.49, 'MA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Ariel Muff', 'amuff17@chron.com', 53, false, 77276.14, 'FL');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Stormi Brahms', 'sbrahms18@mapquest.com', 49, true, 85758.66, 'NJ');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Dulcy Tremblet', 'dtremblet19@home.pl', 47, true, 79857.3, 'VT');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Daphene Kiernan', 'dkiernan1a@sfgate.com', 40, true, 31213.18, 'GA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Mable Monck', 'mmonck1b@rakuten.co.jp', 27, true, 44252.68, 'GA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Halsy Orrow', 'horrow1c@exblog.jp', 37, false, 49459.07, 'CA');
insert into employees (name, email, age, is_manager, salary, location_state) values ('Lucky Marval', 'lmarval1d@uol.com.br', 39, false, 67508.31, 'WA');



-- At this point we have a bunch of records inserted into our employees table let's do some updating and deleting
-- We use the WHERE clause to constrain the record I want to update;
UPDATE employees SET name='Lucky D.C.', email='luckydc@gmail.com' WHERE employee_id = 50;

-- DELETE
-- MAKE SURE TO ADD WHERE CLAUSE
DELETE FROM employees WHERE employee_id=50;

TRUNCATE TABLE employees;


-- Data Query Language (DQL)
-- This is where we'll spend the bulk of our time when writing SQL Queries
-- These are all of the different kinds of select statements

-- Select ALL
SELECT * FROM employees;

-- Specify Specific Columns
SELECT name, age FROM employees;

-- WHERE clause is used for basic filtering
-- Select all the names from employees with salaries greater than $60000
SELECT name, salary FROM employees WHERE salary > 60000;

-- ORDER BY
-- ORDER BY is clause that ALWAYS goes at the end of the query and is used to organize the results by a
-- specific column
SELECT name, salary FROM employees WHERE salary > 60000 ORDER BY salary;

-- Order descending
SELECT name, salary FROM employees WHERE salary > 60000 ORDER BY salary DESC;














