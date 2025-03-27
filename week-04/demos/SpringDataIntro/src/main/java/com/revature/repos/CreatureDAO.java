package com.revature.repos;

import com.revature.models.Creature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Stereotype annotation, it means we want Spring to build this class
public interface CreatureDAO extends JpaRepository<Creature, Integer> {
    /*
    Inside of this interface we define all of the methods that we want to be implemented in the implementing class
    Create
    GetAll
    GetById
    Update
    Delete

    At this point we've extended the JpaRepository interface and we are effectively done, this has implemented ALL of
    our CRUD operations


    What is the JpaRepository? This is a repository interface which defines different methods for interacting with Data
    based off the JPA and hibernate

    Hierarchy: Repository -> CrudRepository -> PagingAndSortingRepository -> JpaRepository

    Repository
        Basic outline to mark a class as a repository
    CrudRepository
        Builds on the basic Repository interface and adds CRUD methods
    PagingAndSortingRepository
        Builds on the CrudRepository and adds in methods for sorting and for pagination (multiple pages)
    JpaRepository
        Builds on the PagingAndSortingRepository and adds in methods for working with batches of data.

    Any no predefined method we can directly add inside of here
     */

    // This uses the JPA Naming conventions to allow us to look up a creature by its type which is a field in its class
    List<Creature> findAllByType(String type);

    // The @Query annotation allows us to write Queries that don't match the method name
    // The below is a native SQL query
    // Native Query = true means this is PURE SQL
    @Query(value = "SELECT * FROM creatures WHERE name LIKE %:keyword%", nativeQuery = true)
    List<Creature> searchByNameNative(@Param("keyword") String keyword);

    List<Creature> findAllByNameContainsIgnoreCase(String name);


    // Using JPQL (Java Persistence Query Language)
    // This is like a combination of SQL and Java so it'll be pretty similar to both but there are some differences
    @Query("SELECT c FROM Creature c WHERE c.habitat.name = :habitatName AND c.age >= :minAge ORDER BY c.age DESC")
    List<Creature> findAllOldCreaturesByHabitat(@Param("habitatName") String habitatName, @Param("minAge") int minAge);

    List<Creature> findAllByHabitat_NameAndAgeGreaterThanEqual(String name, int age);
}
