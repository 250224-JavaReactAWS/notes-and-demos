/*
 * DCL
 * 
 * Subqueries
 * 
 * Normalization
 * 
 * Indexes/Views
 * 
 * Functions/Procedures as well (Watch video on this)
 */

/*
 * DCL -> Data Control Language
 * This is one of our core sublanguages with SQL, we've talked about DDL, DML, DQL, TCL
 * 
 * DCL is in charge of creating DB users and assigning them permissions. This can be done on a table wide basis
 * or on a command wide basis
 * 
 * KEYWORDS: 
 * Grant -> Give permissions to user
 * Revoke -> Remove permissions from user
 */

-- Let's create a user that can access the Users with select and insert
CREATE ROLE john_doe
WITH LOGIN
PASSWORD 'password123';

-- Give john_doe the ability to select and insert different things on the user table
-- GRANT is used to bestow permissions to specific users
GRANT SELECT,INSERT ON users TO john_doe;
-- This lines up with a security principle known as the granting the least amount of privileges
-- But we only want them to be able to access what tables and commands we give to them so we do this permission by
-- permission

-- What happens if I want to remove a permission?
-- REVOKE to remove a permission
REVOKE INSERT ON USERS FROM john_doe;


-- Borrowed from other notes
CREATE TABLE employees(
	employee_id serial PRIMARY KEY,
	name varchar(50) NOT NULL,
	email varchar(50) UNIQUE,
	age int CHECK (age > 0),
	is_manager bool DEFAULT false,
	salary NUMERIC(10,2) NOT NULL CHECK (salary > 0),
	location_state char(2) DEFAULT 'FL' -- char(2) means this MUST be 2 letters, NO MORE NO LESS
);

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

/*
 * Subqueries 
 * 
 * Sometimes we need to perform more complex operations with our select statement, we can do this with a subquery
 * which allows use to have a nested query inside another query
 * 
 *  We can use this in SELECT, FROM and WHERE clauses
 * 
 * 
 */

-- SELECT THE AVERAGE SALARY BY STATE
SELECT location_state, AVG(SALARY) FROM employees GROUP BY location_state ORDER BY AVG(SALARY) DESC LIMIT 1;

-- SELECT all people whose salary is greater than the avg salary
SELECT avg(salary) FROM employees

-- I want all employees whose salary is greater than that number
SELECT name, salary FROM employees WHERE salary > 60908.9426

-- Using a hardcoded value is not good, let's try to do something else
SELECT name, salary FROM employees WHERE salary > (SELECT avg(salary) FROM employees)
-- This is using a subquery and it returns one single value so salary can be compared against it

/*
 * Indexes
 * 
 * An Index is a record held by the SQL database and is used to speed up the process of Querying data
 * 
 * Indexes are typically created for primary keys automatically and they're used as a stored list of values allowing
 * you to query data more efficiently 
 * 
 * Typically you'll use indexes on cloumns you frequently visit, but you shouldn't make an index for everything since
 * it affects the storage space for the db
 */

CREATE INDEX employee_name ON employees(name);

-- Creating this will store all of the names in Memory in a much faster lookup table allowing for more efficient operations
-- when searching by name

SELECT * FROM EMPLOYEES WHERE name = 'Lucky Marval'


/*
 * Views
 * 
 * A View is a virtual table that is stored and can be used and queried from like a regular table but it is actually
 * the result of another query
 * 
 */


-- What happens if I need this information frequently? 
-- Maybe I'd save the query manually somewhere but it makes sense to create a View
SELECT first_name, last_name, courses.name, assignments.name FROM Student_info 
JOIN students ON student_info.student_id = students.student_id
JOIN enrollments ON students.student_id = enrollments.student_id
JOIN courses ON courses.course_id = enrollments.course_id
JOIN assignments ON courses.course_id  = assignments.course_id;


CREATE VIEW students_assignments AS
SELECT first_name, last_name, courses.name AS course_name, assignments.name AS assignment_name FROM Student_info 
JOIN students ON student_info.student_id = students.student_id
JOIN enrollments ON students.student_id = enrollments.student_id
JOIN courses ON courses.course_id = enrollments.course_id
JOIN assignments ON courses.course_id  = assignments.course_id;

-- I can select from a view as if it was a normal table
SELECT * FROM students_assignments WHERE course_name = 'Calculus I';

UPDATE STUDENT_INFO SET last_name = 'Serfozo' WHERE student_id = 3;

SELECT * FROM STUDENT_INFO;
















