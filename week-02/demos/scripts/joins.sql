/*
 *  Relationships and Multiplicity
 * 
 * When talking about SQL databases we've mentioned that they are a series of RELATED tables.
 * These table are going to be related through a primary key - foreign key relationship and the different
 * kinds of relationships are what we mean when we say the word multiplicity.
 * 
 * Multiplicity: How tables can be related
 * - One to One: One record in a table relates to EXACTLY one record in another table
 * 		- Personal Info to a user
 * 		- Employee and workbadge
 * - One to Many: One record in the first table can be related to many records in the next table
 * 		- Authors and Books: One author writes many books and one book is written by a single author
 * 		- Courses and assignments: One course many contain many assignments but one assignment only belongs 
 * 		to a single course
 * 		- Departments and Employees: One department has many employees but each employee belongs to a single 
 * 		department
 * - Many to One: The reverse of one to many, basically the same relationships read from the other table
 * - Many to Many: Describes relationships where many items in the first table are related to many items in
 * 	the second table
 * 		- Students and Courses: One student can enroll in many courses and many students can enroll in one
 * 		course.
 * 		- Actors and Movies: One movie can have many actors and many movies can contain one actor
 * 
 * - NOTE: Many to many relationship is the sum of a one to many and a many to one
 */

-- First let's do students and student info
-- This is a one to one relation
CREATE TABLE students(
	student_id serial PRIMARY KEY,
	email varchar(50) UNIQUE,
	PASSWORD varchar(50)
);

CREATE TABLE student_info(
	student_info_id serial PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	address TEXT,
	phone_number TEXT,
	student_id int,
	FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE
	-- I need to tell the database that the student_ID column is a FOREIGN KEY
	-- A Foreign key is a column that points to / references another tables, usually their PK
);

-- How do I relate the tables to each other?

-- At this point we have a couple of tables, let's add in some information
INSERT INTO STUDENTS (email, password) VALUES 
('bryan.serfozo@revature.com', 'Password'),
('valerie.frizzle@school.com', 'SecretPassword'),
('kaitlyn.graves@example.com', 'VerySecretPassword');

-- Let's add in some information for the student info table
INSERT INTO student_info (first_name, last_name, address, phone_number, student_id) VALUES 
('Bryan', 'Serfozo', '123 Example Street', '1234567890', 1),
('Kaitlyn', 'Graves', '456 Sample Street', '8970213324', 3),
('Valerie', 'Frizzle', '789 Example Street', '0987654321', 2);

-- These records are now related to each other via the foreign key relationship
-- This is supposed to be a 1-1 relationship so let's try to add in another value for the student info
INSERT INTO student_info (first_name, last_name, address, phone_number, student_id) VALUES 
('Not Bryan', 'Not Serfozo', 'test', 'test', 1);
-- This is a problem, we only want ONE student Id matching (we actually have a 1:M right now)

-- Let's alter the table and add a constraint
DELETE FROM student_info WHERE student_info_id = 4;
ALTER TABLE student_info ADD CONSTRAINT one2one UNIQUE(student_id);

-- In a one to one relationship there is a foreign key that is UNIQUE

-- One to Many/ Many to One relationship
-- This should be the same thing without the unique constraint 
-- NOTE: When doing 1:M put the foreign key on the Many table for most purposes
-- Courses and Assignments
-- One course can contain many assignments

CREATE TABLE courses(
	course_id serial PRIMARY KEY,
	name TEXT,
	credits int
);

CREATE TABLE assignments(
	assignment_id serial PRIMARY KEY,
	name TEXT,
	description TEXT,
	max_points int,
	course_id int REFERENCES courses
);

INSERT INTO COURSES (name, credits) VALUES
('Intro to Java', 3),
('Calculus I', 4);

INSERT INTO ASSIGNMENTS (name, description, max_points, course_id) VALUES
('Java Coding Challenge', 'Complete the coding challenge and pass the tests', 100, 1),
('Java Exam', 'Complete the multiple choice exam', 50, 1),
('Calculus Math Test', 'Complete all the math questions', 200, 2);

-- Multiple assignments sharing the same course here

-- Many to Many
-- This is the hardest relationship to represent
-- Many students can sign up for many courses, so we need to represent all of the combinations in 
-- a junction table

CREATE TABLE enrollments(
	student_id int REFERENCES students,
	course_id int REFERENCES courses,
	PRIMARY KEY (student_id, course_id)
);

-- This table functions as a junction between courses and students
-- It has one to many / many to one relationships with each table
-- It contains a COMPOSITE KEY, which is a primary key composing multiple columns (we can't enroll twice)

-- To enroll a student in a course we enter in the combination of student id and course id
INSERT INTO enrollments VALUES
(1,1),
(1,2),
(2,1),
(2,2),
(3,1),
(3,2);

-- Let's try to re enroll in a course
--INSERT INTO enrollments VALUES
--(1,1);

-- Referential Integrity
-- This refers to how records can reference each other in related tables
-- For referential integrity to exist there can be no orphan records or foreign keys pointing to records that
-- don't exist
-- There IS NO course 10
INSERT INTO enrollments VALUES
(1,10); 
-- We cannot enter a record that is referencing something that doesn't exist
DELETE FROM Courses WHERE course_id = 1;
-- I *currently* cannot remove any record that is directly referenced anywhere
-- Cascade allows us to remove or update child records on demand 
-- If I have records referencing course 1 I would just delete them if I tried to remove the course
-- Let's try this with student info

-- If I try to delete a student currently there are enrollments and student info related to them
-- Enrollments are not set to cascade so I will delete them first
DELETE FROM ENROLLMENTS WHERE student_id = 3;
DELETE FROM STUDENTS WHERE student_id = 3;
-- Since student info is set to cascade when I delete student 3 it will just remove that record as opposed
-- to throwing an error


-- Right now all of our information is separated into many different tables that make it hard to find
-- all of the info I want 

-- JOINS
-- Joins are a way of bringing info from multiple SQL tables together based off a join predicate
-- INNER JOIN
-- Displays all the records from each table that have a matching record in the other table
INSERT INTO STUDENTS (email, password) VALUES
('kaitlyn.graves@example.com', 'VerySecretPassword');

SELECT * FROM student_info;

SELECT first_name, last_name, email, address, phone_number 
FROM STUDENTS 
JOIN STUDENT_INFO
ON STUDENTS.STUDENT_ID = STUDENT_INFO.STUDENT_ID;

-- LEFT JOIN
-- Left shows ALL of the information from the left (first) table and only the matching records from the
-- right table
SELECT *
FROM STUDENTS 
LEFT JOIN STUDENT_INFO
ON STUDENTS.STUDENT_ID = STUDENT_INFO.STUDENT_ID;


-- RIGHT JOIN
-- Reverse of the left join. Shows all info in the right table only matching records in the left table
SELECT *
FROM STUDENT_INFO
RIGHT JOIN students 
ON STUDENTS.STUDENT_ID = STUDENT_INFO.STUDENT_ID;

-- OUTER JOIN
-- Shows all the records from all tables even if they dont match up to anything
-- Only really useful for finding orphaned records
-- Enter a student info that doesn't reference a student
INSERT INTO STUDENT_INFO (FIRST_NAME, LAST_NAME, ADDRESS, PHONE_NUMBER) VALUES
('Test', 'Test', '123 Test St', '911');

SELECT * FROM Student_info;

SELECT *
FROM STUDENTS 
FULL OUTER JOIN STUDENT_INFO
ON STUDENTS.STUDENT_ID = STUDENT_INFO.STUDENT_ID;


-- NATURAL JOIN
-- This is a special kind of join which is the same as the other ones but uses column names to line things
-- up
SELECT *
FROM STUDENTS 
JOIN STUDENT_INFO
ON STUDENTS.STUDENT_ID = STUDENT_INFO.STUDENT_ID;

SELECT * FROM STUDENTS
NATURAL JOIN STUDENT_INFO;
-- Recognizes that student_id is shared between the columns so it uses that to join the tables

-- Let's try to show a student's name, email and all assignments associated with them
-- We can join more than 2 tables as well
SELECT first_name, last_name, email, c.name, a.name 
FROM student_info si
JOIN students s
ON si.student_id = s.student_id
JOIN enrollments e
ON s.student_id = e.student_id
JOIN courses c
ON e.course_id = c.course_id
JOIN assignments a
ON c.course_id = a.course_id;

SELECT first_name, last_name, email, c.name, a.name 
FROM student_info si
NATURAL JOIN students s
NATURAL JOIN enrollments e
NATURAL JOIN courses c
JOIN assignments a
ON c.course_id = a.course_id;











