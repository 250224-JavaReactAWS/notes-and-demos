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