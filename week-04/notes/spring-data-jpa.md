## Spring Data JPA
At this point, we have already utilized the Data Access Object (DAO) Layer to handle communication of data between our application and our repository. This DAO layer usually consists of a lot of boilerplate code, and as such can and should be simplified. There are numerous reasons to simplfy this code, including a decrease in the number of artifacts that need to be defined and maintained, consistency of data access patters, consistency of configuration, and quicker implementation for updated repository data.

The Spring Data module takes this simplification one step further by providing standard implementation for common DAO methods allowing for the removal of the DAO implementation and only requiring the definition of the DAO interface methods.

In order to leverage the Sping Data programming model with JPA, a DAO interface should extend the Spring _JpaRepository_ interface from the `org.springframework.data.jpa.repository` package. Note that it is possible to create a basic CRUD application by extending the spring _CrudRepository_ interface (from the `org.springframework.data.repository` package), though this only provides an interface for generic CRUD operations on a repository, and does not leverage the JPA.

<img src ="https://media.geeksforgeeks.org/wp-content/uploads/20211210003119/crudvsjpadrawio.png">

Implementation of the Spring _JpaRepository_ provides the following:
* Sophisticated support to build repositories based on Spring and JPA
* Support for QueryDSL predicates and thus type-safe JPA queries 
  * QueryDSL is a framework which enables statically typed SQL-like queries, instead of requiring inline string queries or external XML files.
* Transparent auditing of Domain class
* Pagination (sequential numbering) support
* Dynamic query execution
* Support for integration of custom data access code
* Validation of `@Query` annotated queries during bootstrapping
* Support for XML based entity mapping
* JavaConfig based repository configuration by introducing `@EnableJpaRepositories`


Though the actual implementation of the Spring Data managed DAO is hidden (as we don't work with it directly) it is a simple enough implementation. In fact, Spring JPA provides a _SimpleJpaRepository_ interface, which extends the JpaRepository, that defines transaction semantics using annotations. Specifically, a read-only `@Transactional` annotation is used at the class level, which is then overridden for the nonread-only methods. The rest of the transaction semantics are default, but can easily be overridden manually on a per-method basis.


# Spring Data Annotations

This page is a brief overview of the some of the Spring Data annotations. Please see the reference links for the official documentation

### References

- [Spring Data Annotations](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/annotation/package-summary.html)

## Spring Data Annotations

Spring Data abstracts away the code required for data storage solutions, allowing us to focus more on the business logic. The following is a list and brief explanation of some common Spring Data annotations which allow us to configure how the queries are executed.

| Annotation                      | Purpose                                                                                   |
| ------------------------------- | ----------------------------------------------------------------------------------------- |
| @Transactional                  | Configure how the database transaction behaves.           |
| @NoRepositoryBean               | Creates and interface that provides common methods for child repositories                 |
| @Param                          | Parameters can be passed to queries defined with @Query                                   |
| @Id                             | Marks a field in a model class as the primary key                                         |
| @Transient                      | Mark a field as transient, to be ignored by the data store engine during reads and writes |
| @CreatedBy, @LastModifiedBy     | Auditing annotations that will automatically filled with the current principal            |
| @CreatedDate, @LastModifiedDate | Auditing annotations that will automatically fill with current date                       |
| @Query                          | Supply a JPQL query for repository methods                                                |

### NoRepositoryBean

```java
@NoRepositoryBean
public interface MyRepoBase<T, ID extends Serializable> extends JpaRepository<T, ID> {
    Optional<List<T>> findAllByPrice(Double price);
}

@Repository
public inteface BookRepo extends MyRepoBase<Book, Integer> {}
```

The interface `MyRepoBase` can now serve as a base for children repos like `BookRepo`. Spring will not create a bean of type `MyRepoBase`, but will create a `BookRepo` bean which will include all of the `JpaRepository` methods and also `findAllByPrice` from `MyBaseRepo`

### @Param

```java
@Repository
public inteface BookRepo extends MyRepoBase<Book, Integer> {

    @Query("FROM Book b WHERE b.title LIKE :title")
    Optional<List<T>> findBySimilarTitle(@Param("title") String title);
}
```

The `@Param` annotation binds the method parameter to the `title` parameter of `@Query`.

### @Id

This is essentially the same as the JPA annotation.

### @Transient

This is essentially the same as the JPA annotation.

### @CreatedBy, @LastModifiedBy, @CreatedDate, @LastModifiedDate

```java
public class Book {
    @CreateBy
    public User creator;

    @LastModifiedBy
    public User modifier;

    @CreatedDate
    public Date createdAt;

    @LastModifiedDate
    public Date modifiedAt;
}

```

### @Query

```java
@Query("SELECT COUNT(*) FROM Book b)
long getBookInventoryCount();
```

JPQL query.

```java
@Query("FROM Book b WHERE b.title LIKE :title")
Optional<List<T>> findBySimilarTitle(@Param("title") String title);
```

With named parameters.

```java
@Query("SELECT AVG(b.page_count) FROM Book b", nativeQuery=true)
int getAvgPageCount();
```

Natvie SQL query.

## Transaction Management

When designing database transactions to be performed in Java or any other programming language other than SQL, it is important to consider that multiple transactions will performed simultaneously. Managing all of these transactions can be tedious and cumbersome becuase it requires complicated strategies for read/write locking and thread management. JDBC and connection pool utilities like Hikari have built-in tools for handling these issues, but still will require a lot of boiler plate code to achieve the consistency required for your data.

## @Transactional

When using `Spring` and `Spring ORM` or `Spring Data` your chosen ORM can be configured to use a transaction manager that will automatically handle transaction propagation, and isolation, commit, and rollback. Assuming you understand how to configure `Spring` to use `Hibernate` and a `TransactionManager`, utilizing the management tools is as simple as annotating a class or method with `@Transactional`.

For best practice usage `@Transactional` should be used on your `@Service` beans since a transaction is a unit of work with its success or failure directly tied to the requirements of the application and not necessrarily to the model. The side-effects of a transaction can be assumed to be either `commit` or `rollback` therefore the model will be consistent, but the `@Service` will be required to react accordingly.

Below is a list of the attributes for `@Transactional`

| Attribute              | Purpose                                                                                                                                                                 |
| ---------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| isolation              | The transaction isolation level.                                                                                                                                        |
| noRollbackFor          | Defines zero (0) or more exception Classes, which must be subclasses of Throwable, indicating which exception types must not cause a transaction rollback.              |
| noRollbackForClassName | Defines zero (0) or more exception names (for exceptions which must be a subclass of Throwable) indicating which exception types must not cause a transaction rollback. |
| propagation            | The transaction propagation type.                                                                                                                                       |
| readOnly               | A boolean flag that can be set to true if the transaction is effectively read-only, allowing for corresponding optimizations at runtime.                                |
| rollbackFor            | Defines zero (0) or more exception classes, which must be subclasses of Throwable, indicating which exception types must cause a transaction rollback.                  |
| rollbackForClassName   | Defines zero (0) or more exception names (for exceptions which must be a subclass of Throwable), indicating which exception types must cause a transaction rollback.    |
| timeout                | The timeout for this transaction (in seconds).                                                                                                                          |
| transactionManager     | A qualifier value for the specified transaction.                                                                                                                        |

### @Transactional Usage

The following examples assume the usage of `Spring ORM` since the query structure and operations of `Spring Data` are abstracted away.

```java
@Service
@Transactional // all methods in this class will utilize the tx manager and contextual sessions
public class MyService {
    ...
    public List<MyData> readMyData(...){...}
}
```

The above code creates a service bean that utilizes the transaction manager. By annotating the class, all methods are implicated in the use of the manager.

```java
@Service
@Transactional // all methods in this class will utilize the tx manager and contextual sessions with default configuration
public class MyService {
    ...
    @Transactional(readonly=true, isolation=Isolation.READ_COMMITTED, propagation=Propagation.NEVER) //override the default config
    public List<MyData> readMyData(...){...}
}
```

The above code expands on the previous example. `@Transactional` can be used on classes or methods or both. In this example, the class uses the transaction manager with default configuration, but the method overrides the default configuration. If you are unfamiliar with the attributes being used, don't worry to much about that right now.

```java
@Service
@Transactional // all methods in this class will utilize the tx manager and contextual sessions
public class MyService {
    ...
    @Transactional(isolation=Isolation.SERIALIZABLE, rollbackFor={ConstraintViolationException.class}, propagation=propagation.REQUIRES_NEW) // override when the transaction should rollback.
    public Integer createNewData(...){...}
}
```

In the above example the code demonstrates how to configure the transaction manager with a list of exceptions that must cause a rollback to be triggered. Normally the transaction manager will always rollback for any RuntimeException or RuntimeException subclass (unchecked exceptions) however, the transaction manager will not automatically rollback for Exception (checked exceptions)

## Transaction Propagation.

When designing database transactions to be performed in Java or any other programming language other than SQL, it is important to ask this question, "How will transactions behave over multiple method calls"? If `Method1` calls `Method2`, how will transactions propagate. Transaction propagation falls into the following categories.

|   Strategy    | Purpose                                                                                              |
| :-----------: | :--------------------------------------------------------------------------------------------------- |
|   Mandatory   | Support a current transaction, throw an exception if none exists.                                    |
|    Nested     | Execute within a nested transaction if a current transaction exists, behave like REQUIRED otherwise. |
|     Never     | Execute non-transactionally, throw an exception if a transaction exists.                             |
| Not Supported | Execute non-transactionally, suspend the current transaction if one exists.                          |
|   Required    | Support a current transaction, create a new one if none exists.                                      |
| Requires New  | Create a new transaction, and suspend the current transaction if one exists.                         |
|   Supports    | Support a current transaction, execute non-transactionally if none exists.                           |

### Propagation Usage

```java
@Service
public class MyService {
    ...

    @Transactional(readonly=true, propagation=Propagation.NEVER)
    public List<MyData> readMyData(){...}
}
```

The above code use the transaction manager to create a read only, transactionless transaction state. Generally speaking readonly operations are idempotent and safe so an argument for never having a transaction present can be made. This is not necessarily a best practice.

```java
@Service
public class MyService{
    @Autowired
    private MyService2 myService2;
    ...
    @Transactional(propagation=Propagation.REQUIRED_NEW)
    public Integer createNewData(...){
        myService2.createSupportingData(...);
        ....
    }
}

@Service
public class MyService2{
    ...
    @Transactional(propagation=Propagation.MANDATORY)
    public Integer createSupportingData(...){...}
}
```

The above code creates a more complicated situation. From the `MyService` perspective, it is easy to see that the `createNewData` method will require a new transaction be created, but the dependency on `MyService2` complicates the operation. The example simplifies the problem by assuming that `createSupportingData` of `MyService2` not only requires a transaction, but will fail if one isn't present. Essentially the example creates a situation where the data write for `MyService` is contigent on the data write from `MyService2` at the transaction level, using this strategy we have created an atomic multioperational transaction which will increase the likely hood of maintaining a consistent state.
 