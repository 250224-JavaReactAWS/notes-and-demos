package com.revature.repos;

import com.revature.models.Biography;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// The next set of annotations are called Stereotype Annotations and they tell Spring how to work with a class and
// that Spring needs to manage the class itself

@Repository
public interface BiographyDAO extends JpaRepository<Biography, Integer> {

    // This interface is extending ANOTHER interface

    /*
    This is a DAO interface. DAO stands for Data Access Object and this interface is directly responsible for
    working with our SQL database. This class will have methods inside of it to perform CRUD methods against the database

    CRUD Methods:
    - Create new data
    - Read existing data
    - Update existing data
    - Delete existing data

    We can also define some custom methods inside of here
    With Spring, a lot of the heavy lifting is done for us, but we'll see all of the inner workings when we get to JDBC


    First, an interface in Java is a structure similar to a class, but you typically on define method signatures here
    An interface is typically implemented by some class and in that class you will fill out the method body for all of
    the method signatures
     */

    // We can define any methods we want inside of here
    List<Biography> getAllByName(String name);
    // This method listed above will be in charge of interacting with a SQL database and executing the statement
    // SELECT * FROM BIOGRAPHIES WHERE NAME = ?
}
