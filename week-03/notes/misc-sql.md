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

# Set Operations

<img src= "https://www.essentialsql.com/wp-content/uploads/2017/03/SetOperators.png">

Set operators are different from joins. Instead of combining columns of two tables, set operators combine the rows of different result sets. Essentially, set operators perform some kind of (set) operation on two different queries.

Some set operators are:

* UNION [ALL]
  * UNION does not keep duplicates, but UNION ALL will
* INTERSECT
  * Only returns records in common between the queries
* EXCEPT
  * Removes from the first result set any rows that appear in the second result set and returns what remains


# Index 

An index is a common way to enhance database performance, enabling faster retrieval. When creating an index, the database stores an in memory ordering of a particular column. Without an index, if we were searching on a particular column, we would need to check every single value in that column to return the result. Indexes allow those operations to be more efficient. Columns which are searched on frequently, and that have a high percent of unique values and a low percent of null values are generally good candidates for an index. While indexes can make searching operations more efficient, we need to be careful not to use indexes too liberally. Because we are storing an additional ordering in memory, they need to be maintained every time we perform operations like insertions and deletions, so they may not always be the best choice.

# Views

There are two types of views in Postgres which allow us to view a dataset from a query. A traditional *view* will store a query in memory. Each time we make a request to that view, the query is executed and the result set is retrieved from the database.  There is also such thing as a *materialized view.* This type of view stores the actual dataset in memory. Each time we make a request to a materialized view, it does not execute the query again, but rather returns the saved dataset. To update the dataset, the materialized view must be refreshed.

```sql
create [materialized] view as [query]
```

# Normalization

Normalization refers to an optimization process of structuring a relational database in a way that *reduces redundancy* of data and improves data integrity and consistency. There are many different normal forms, which relate to the degree to which a database has been normalized. We will look at the first three normal forms, each of which build upon the previous:

* 1NF - must have a primary key, no repeating groups, and atomic columns
* 2NF - must already be in 1NF, plus have no partial dependencies
* 3NF - must already be in 2NF, plus have no transitive dependencies

The first normal form enforces that a table **must**:
* Have a primary key
* Each column should be as granular as possible (e.g. "Name" column should be broken up into: "First Name", "Last Name", "Middle Name", etc..)

To be in second normal form, a table must **also**:
* Cannot have columns that are dependent on only one part of the key
* If there are no composite primary keys, you are automatically in 2NF

Finally, to get to third normal form, a table must **also**:
* Not have transitive dependencies
* This means that if column C relates to column B which relates to column A which is the primary key, this is not in 3NF because C is related to the primary key but indirectly (it is a transitive dependency)

To advance into higher normal forms, we typically "break up" tables into multiple tables and relate them to each other via foreign keys.

**invoice**

| invoice_id | customer_name | date        | item       | price | quantity | line price | total |
| ---------- | ------------- | ----------- | ---------- | ----- | -------- | ---------- | ----- |
| 201        | Peter         | 2 June 2020 | Coffee     | 5.00  | 2        | 10.00      | 25.00 |
| 201        | Peter         | 2 June 2020 | Milk       | 3.00  | 1        | 3.00       | 25.00 |
| 201        | Peter         | 2 June 2020 | Bread      | 4.00  | 3        | 12.00      | 25.00 |
| 204        | Patrick       | 3 June 2020 | Cereal     | 3.50  | 3        | 10.50      | 29.25 |
| 204        | Patrick       | 3 June 2020 | Wine       | 7.00  | 2        | 14.00      | 29.25 |
| 204        | Patrick       | 3 June 2020 | Watermelon | 4.75  | 1        | 4.75       | 29.25 |

---

**invoice**

| _invoice_id_ | customer_name | date        | _line_number_ | item       | price | quantity | line price | total |
| ------------ | ------------- | ----------- | ------------- | ---------- | ----- | -------- | ---------- | ----- |
| 201          | Peter         | 2 June 2020 | 1             | Coffee     | 5.00  | 2        | 10.00      | 25.00 |
| 201          | Peter         | 2 June 2020 | 2             | Milk       | 3.00  | 1        | 3.00       | 25.00 |
| 201          | Peter         | 2 June 2020 | 3             | Bread      | 4.00  | 3        | 12.00      | 25.00 |
| 204          | Patrick       | 3 June 2020 | 1             | Cereal     | 3.50  | 3        | 10.50      | 29.25 |
| 204          | Patrick       | 3 June 2020 | 2             | Wine       | 7.00  | 2        | 14.00      | 29.25 |
| 204          | Patrick       | 3 June 2020 | 3             | Watermelon | 4.75  | 1        | 4.75       | 29.25 |

---

invoice_line

| invoice_id | line_number | item       | price | quantity | line price |
| ---------- | ----------- | ---------- | ----- | -------- | ---------- |
| 201        | 1           | Coffee     | 5.00  | 2        | 10.00      |
| 201        | 2           | Milk       | 3.00  | 1        | 3.00       |
| 201        | 3           | Bread      | 4.00  | 3        | 12.00      |
| 204        | 1           | Cereal     | 3.50  | 3        | 10.50      |
| 204        | 2           | Wine       | 7.00  | 2        | 14.00      |
| 204        | 3           | Watermelon | 4.75  | 1        | 4.75       |

invoice

| invoice_id | customer_name | date        | total |
| ---------- | ------------- | ----------- | ----- |
| 201        | Peter         | 2 June 2020 | 25.00 |
| 204        | Patrick       | 3 June 2020 | 29.25 |

---

invoice_line

| invoice_id | line_number | item_no | quantity |
| ---------- | ----------- | ------- | -------- |
| 201        | 1           | 73627   | 2        |
| 201        | 2           | 76283   | 1        |
| 201        | 3           | 72463   | 3        |
| 204        | 1           | 84726   | 3        |
| 204        | 2           | 83725   | 2        |
| 204        | 3           | 82617   | 1        |

invoice

| invoice_id | customer_name | date        |
| ---------- | ------------- | ----------- |
| 201        | Peter         | 2 June 2020 |
| 204        | Patrick       | 3 June 2020 |

item

| item_no | name       | price |
| ------- | ---------- | ----- |
| 73627   | Coffee     | 5.00  |
| 76283   | Milk       | 3.00  |
| 72463   | Bread      | 4.00  |
| 84726   | Cereal     | 3.50  |
| 83725   | Wine       | 7.00  |
| 82617   | Watermelon | 4.75  | 


# Subqueries

Subqueries are essentially queries held within another query
* Useful for combining queries together to minimize change required by developer or analyst
* Can go anywhere in the `SELECT`, `FROM`, or `WHERE` clauses
* Must be contained entirely within parantheses
* If used with a `WHERE` clause it must be aliased
* Can be used with DML commands (`INSERT`, `SELECT`, `UPDATE`, `DELETE`)

## PL/SQL

PL/SQL stands for the Procedural Language extension to SQL and it is a complete programming language which also allows SQL statements.

Besides the programming itself, Oracle offers an OOP aspect to its databases, providing certain types of objects, some of which require PL/SQL code. CREATE [OR REPLACE] and DROP statements are allowed for these objects. ALTER is not allowed.

### Sequence

A **sequence** is an object which holds a numeric number that starts from a certain point and it also contains a max. It increments by a specific amount every time NEXTVAL is called.

They can be combined with **Triggers** to auto increment primary key columns.

```sql
CREATE [OR REPLACE] SEQUENCE START WITH 1 INCREMENT BY 1
```

### Trigger

A **trigger** is a block of code that executes when a specific event happens. These events can be INSERT, UPDATE or DELETE statements, and they can happen AFTER or BEFORE.

Syntax:

```sql
CREATE [OR REPLACE] TRIGGER 
BEFORE INSERT ON TABLE_NAME
  FOR EACH ROW
  BEGIN
    (PL/SQL code)
  END;
```

### Cursor

Pointers to a result set. They can be used to loop programmatically on the output of a SELECT statement (similar to iterators in Java).

Oracle provides `SYS_REFCURSOR`, its own type of `REFCURSOR`. This means you can create your own type of `REFCURSOR`. 

### Stored Procedure

PL/SQL code that can be executed in certain ways and has some properties:

* They don't return anything.
* They may or may not contain IN (by value) and OUT (by reference) parameters.
* They allow any DML statements within.
  * These means transactions can be created in a stored procedure.
* Stored procedures can call other procedures and functions.
* Can NOT use stored procedures in DML statements.
  * `EXEC STORED_PROCEDURE`

### Function

Also known as User Defined Functions, these are like stored procedures but have some other restrictions or abilities:

* They must return something.
* Cursors are allowed.
* It should be a single value.
* They may or may not contain IN parameters (by default).
* Only SELECT statements are allowed.
* Functions can only call other functions (no stored procedures).
* They can be used in any DML statement.
* To call a function, you have to use a DML statement (you can't `EXEC`).
* Use `FROM DUAL` if you are not selecting from a specific table.
* `DUAL` is a dummy table which returns anything your throw at it.

