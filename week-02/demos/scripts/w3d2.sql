/*
 * DQL (Data Query Language)
 * This is a SQL sublanguage that's sometimes considered part of DML. It has to with the SELECT
 * statement along with all of the various clauses that can go with it
 * 
 * - WHERE
 * - ORDER BY
 * - HAVING
 * - LIKE
 * - BETWEEN
 * - GROUP BY
 */

CREATE TABLE products(
	product_id serial PRIMARY KEY,
	name varchar(50) NOT NULL,
	price numeric(4,2) CHECK (price > 0)
);

-- Let's add in some products
insert into products (name, price) values ('Juice - V8, Tomato', 18.84);
insert into products (name, price) values ('Juice - Clam, 46 Oz', 17.46);
insert into products (name, price) values ('Cup - 4oz Translucent', 9.28);
insert into products (name, price) values ('Pastry - Banana Tea Loaf', 19.09);
insert into products (name, price) values ('Schnappes Peppermint - Walker', 6.37);
insert into products (name, price) values ('Onions - Spanish', 5.64);
insert into products (name, price) values ('Onions - Dried, Chopped', 2.02);
insert into products (name, price) values ('Wine - Mas Chicet Rose, Vintage', 19.18);
insert into products (name, price) values ('Cheese Cheddar Processed', 11.8);
insert into products (name, price) values ('Hersey Shakes', 11.59);
insert into products (name, price) values ('Potatoes - Purple, Organic', 2.37);
insert into products (name, price) values ('Wine - White, Mosel Gold', 17.81);
insert into products (name, price) values ('Wine - Red, Metus Rose', 15.8);
insert into products (name, price) values ('Pastry - Banana Tea Loaf', 12.85);
insert into products (name, price) values ('Cookies Almond Hazelnut', 17.52);


-- SELECT All of the information
SELECT * FROM products;

-- Filter using the WHERE clause
SELECT * FROM products WHERE price < 10;

-- Filter based off multiple criteria using AND and OR
-- Logical AND -> Both sides must be true to return true
-- Logicial OR -> At least one side must be true to return true
SELECT * FROM products WHERE price < 10 AND price > 5;

SELECT * FROM PRODUCTS WHERE price < 5 OR product_id % 2 = 0;
-- Price is less than $5 OR the product_id is even

-- SELECT Specific columns by name
SELECT product_id FROM products;
-- Recall you can put the column names in ""
SELECT "name" FROM products;

-- LIKE or ILIKE in PostgreSQL allows you to do text processing
-- _ means one random character
-- % means 0 or more random characters
SELECT * FROM products WHERE name LIKE 'Onions%';
-- The string MUST begin with Onions and have any number of characters behind it

-- Let's select all of the names where the second letter is o
SELECT * FROM products WHERE name LIKE '_o%';

-- Check if string contains some value
SELECT name FROM products WHERE name LIKE '%Wine%';
-- CASE SENSITIVE

SELECT name FROM products WHERE name ILIKE '%onions%';
-- Not every language has ILIKE but PostgreSQL does have it
-- Case INSENSITIVE

-- Using the employee data table from yesterday
SELECT * FROM employees;


-- What if I wanted to know where all of our employees are located?
SELECT location_state FROM employees;
-- This shows duplicates, what happens if I only want unique values
-- DISTINCT is a keyword you can apply to columns to only result in unique values
SELECT DISTINCT(location_state) FROM employees;
-- Still hard to read let's organize alphabetically
-- ORDER BY allows us to sort based off a column's value
SELECT DISTINCT(location_state) FROM EMPLOYEES ORDER BY location_state;

-- ORDER BY is typically ASCENDING order but we can change it to descending like so
SELECT * FROM PRODUCTS ORDER BY price DESC;

-- Let's say I wanted to find the top 10 earners in the list of employees
-- We can do this by LIMITING
SELECT * FROM EMPLOYEES ORDER BY SALARY DESC LIMIT 10;
-- Maybe we also want to offset for things like pagination
SELECT * FROM EMPLOYEES ORDER BY SALARY DESC LIMIT 10 OFFSET 5;
-- LIMIT Removes entries from the end, OFFSET removes entries from the beginning

-- Double back towards AND and check out between
-- Let's get all employees with salaries between 50k and 70k
SELECT * FROM EMPLOYEES WHERE salary >= 50000 AND salary <= 70000 ORDER BY SALARY DESC;
-- We can reformat this using between to combine the and statement
SELECT * FROM employees WHERE salary BETWEEN 50000 AND 70000;
-- Benefits -> easier to read syntax 

-- IN is a keyword that allows you to look in a list of values
SELECT * FROM PRODUCTS WHERE product_id IN (1,2,3,5,8,13);
-- If the ProductID matches ANY value in the list of values it will be added to the resultset.








