# Joins

<img src = "https://www.dofactory.com/img/sql/sql-joins.png">

- allows us to create a single query which spans across multiple tables in our db
- there are various different types of joins, based on what information you would like from each table, and how you define the tables to be joined together
- the typical join syntax is a follows:
- inner, left (outer), right (outer), full (outer)

```sql
select [columns]
from [left table]
left/right/full join [right table]
on [join predicate];
```

There are various different types of joins, based on what information you would like from each table, and how you define a join predicate. A *theta* join is just a join which joins two tables based on some condition (defined above as the join predicate). An *equi* join, is a theta join, where that condition uses equality. 

```sql 
select employee.name, department.name
from employee
left join department
on department.id = employee.department;
```

We also have such joins as *natural* joins. These joins are implicit and do not need a join predicate. Instead, the join is performed based on columns with the same names. In the employee/department example above, if the department table had an id column with the name 'dept_id' and the employee table had a column with the name 'dept_id' which referred to the department table, a natural join could be performed.

```sql 
select employee.name, department.name
from employee
natural join department
```

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
