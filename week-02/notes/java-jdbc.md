# JDBC

JDBC stands for Java Database Connectivity. It is a relatively low-level API used to write Java code that interacts with relational databases via SQL.

## JDBC Introduction
The [JDBC classes and interfaces](https://docs.oracle.com/javase/8/docs/api/index.html?java/sql/package-summary.html) are located in the `java.sql` and `javax.sql` packages. There are several key classes and interfaces that are commonly encountered when writing JDBC code:
* `DriverManager` class - to make a connection with a database driver
* `DataSource` interface - for retrieving connections, an alternative to `DriverManager`
* `Connection` interface - represents a physical connection with a database
* `SQLException` class - a general exception thrown when something goes wrong when accessing the database
* `Statement` interface - used for executing static SQL statements
* `PreparedStatement` interface - represents pre-compiled SQL statements
* `CallableStatement` interface - used to execute stored procedures
* `ResultSet` interface - represents data returned from the database

## Creating a Database Connection
In order to interact with a database, we need to do several things:
1. Register the JDBC driver
2. Open a connection using:
  - Database URL
  - Username
  - Password
3. Execute some SQL statement using either:
  - `Statement`
  - `PreparedStatement`
  - `CallableStatement`
4. Retrieve the results that are returned in a `ResultSet` object

## Creating a Connection
Now we can use the `DriverManager` class to get a `Connection` to the database, given that we have the JDBC URL, username, and password. Generally these parameters should be stored in an external configuration file that can be loaded dynamically and changed without affecting the application code.

```java
try (Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD)) {
  // more code goes here
} catch (SQLException e) {}
```

It's always a good idea to close your resources - here we've used the `try-with-resources` syntax to automatically close the `Connection` being created after the block ends.

## Singleton Pattern
A Singleton is a design pattern which allows the creation of an object in memory only once in an application and can be shared across multiple classes. It can be useful for services in an application, or other resources like a connection or thread pool.

To make a class into a Singleton, use:
1. `private static` variable of the class' type
2. `private` constructor - to prevent arbitrary object creation
3. `public static getInstance()` method, which will either instantiate the object or return the instance in memory
```java
    public class Singleton {
        // Private static variable of the class' type
        private static Singleton instance;

        // Private Constructor
        private Singleton() {}

        // Public static getInstance method
        public static Singleton getInstance() {
            if (instance == null) 
                instance = new Singleton();
            return instance;
        }
    }
```


## JDBC String

The database URL is an address pointing to the database to be used, also known as the JDBC String. The format of this URL varies between database vendors, as shown in the table below:

| RDBMS | JDBC driver | URL format |
| ----- | ----------- | ---------- |
| MySQL | `com.mysql.jdbc.Driver` | jdbc:mysql://hostname/databaseName |
| Oracle | `oracle.jdbc.driver.OracleDriver` | jdbc:oracle:thin:@hostname:portNumber:databaseName |
| SQLServer | `com.microsoft.sqlserver.jdbc.SQLServerDriver` | jdbc:sqlserver://serverName:portNumber;property=value |
| PostgreSQL | `org.postgresql.Driver` | jdbc:postgresql://hostname:port/databaseName |

## Executing SQL
Once we have the `Connection` object, we can write our SQL and execute it:

```java
Statement stmt = conn.createStatement();
String sql = "SELECT * FROM employees";
ResultSet rs = stmt.executeQuery(sql);
```

Alternatively, a `PreparedStatement` can be used. This interface gives us the flexibility of specifying parameters with the `?` symbol. It also protects against [SQL injection](https://en.wikipedia.org/wiki/SQL_injection) when user input is used by pre-compiling the SQL statement.

```java
PreparedStatement ps = conn.prepareStatement();
String sql = "SELECT * FROM employees WHERE age > ? AND location = ?";
ps.setInt(1, 40);
ps.setString(2, "New York");
ResultSet rs = ps.executeQuery(sql);
```

The `Statement` and `PreparedStatement` also have additional methods for sending SQL, including:
* `.execute()` - for any kind of SQL statement, returns a `boolean`
* `.executeUpdate()` - for DML statements, returns an `int` which is the number of rows affected

### Retreiving Results
Results from an SQL query are returned as a `ResultSet`, which can be iterated over to extract the data:

```java
List<Employee> empList = new ArrayList<>();
while (rs.next()) {
  int id = rs.getInt("id");
  String name = rs.getString("first_name");
  empList.add(new Employee(id, name));
}
```

## Data Access Objects
When writing JDBC code, the application business logic may get mixed in with JDBC boilerplate code for querying the database, resulting in hard to read spaghetti code. One way to address this problem is to logically separate the code that accesses the database into Data Access Objects - this is referred to as the **DAO design pattern**.

To use the DAO design pattern, define an interface which declares methods through which the database will be queried. Then, concrete implementation classes can implement the interface and contain the data access logic to return the required data.

For example, if we have an Employee table in our database we'd like to query, we would create a `EmployeeDAO` interface:

```java
public interface EmployeeDAO {
  // define some CRUD operations here
  public List<Employee> getAllEmployees();
  public List<Employee> getEmployeesByLocation(String location);
  public void updateEmployeeById(int id);
  public void deleteEmployeeById(int id);
  public void addEmployee(Employee e);
}
```

This interface would be implemented for a specific database - e.g. Oracle:

```java
public class EmployeeDAOImpl implements EmployeeDAO {
  public List<Employee> getAllEmployees() {
    List<Employee> list = new ArrayList<>();
    // JDBC code here...
	return list;
  };
  public List<Employee> getEmployeesByLocation(String location) {
    List<Employee> list = new ArrayList<>();
    // JDBC code here...
	return list;
  };
  public void updateEmployeeById(int id) {
    // JDBC code here...
  };
  public void deleteEmployeeById(int id) {
    // JDBC code here...
  };
  public void addEmployee(Employee e) {
    // JDBC code here...
  };
}
```

Now whenever we need to query the Employee table in the database, we have a simple, clean interface which abstracts the data access logic:

```java
EmployeeDAO dao = new EmployeeDAOImpl();
List<Employee> allEmpls = dao.getAllEmployees();
allEmpls.forEach( e -> System.out.println(e));

List<Employee> NYEmpls = dao.getEmployeesByLocation("New York");
NYEmpls.forEach( e -> System.out.println(e));
```

Also, we can simply swap out the concrete class `EmployeeDAOImpl` for another database-specific class if we need to at some point in the future, since we rely only on the `EmployeeDAO` interface. The implementation doesn't even need to be talking to a database - it could be reading and writing to files for all we know! We don't care **how** the data is being read or written, we just care **what operations** are defined for the object. That is the benefit the DAO design pattern brings to the table.

