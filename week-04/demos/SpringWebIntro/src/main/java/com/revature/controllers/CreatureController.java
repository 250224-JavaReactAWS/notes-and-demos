package com.revature.controllers;

import com.revature.exceptions.CreatureNotFoundException;
import com.revature.models.Creature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@Controller // This is a Stereotype annotation that allows us to mark this class as a Spring Bean
//@ResponseBody // This is an annotation that can be used on the class or method level. If on the class level we implicitly
                // turn the response of the method in JSON and return that as the result

@RestController // This is an annotation from Spring Web and it combines @Controller and @ResponseBody
@RequestMapping("creatures") // This makes it so EVERY endpoint in this class is prefixed with "/creatures"
public class CreatureController {
    /*
    This class is going to be our first controller class. In this class we'll define various endpoints as well as mappings
    for different methods to those endpoints. Typically this class would call a service layer, we're skipping that for
    now.

    RECALL:
    RESTful naming convention for our endpoints
    CRUD
    Create -> POST -> http://localhost:8080/creatures
    Read -> GET -> http://localhost:8080/creatures
    Read (One) -> GET -> http://localhost:8080/creatures/{creatureId}
    Update -> PUT/PATCH -> http://localhost:8080/creatures/{creatureId}
    Delete -> DELETE -> http://localhost:8080/creatures/{creatureId}

    Filtering of a resource
    Read -> GET -> http://localhost:8080/creatures?country=USA
     */

    private List<Creature> creatureList = new ArrayList<>(List.of(
            new Creature(1, "Bigfoot", "USA", 40),
            new Creature(2, "Mothman", "USA", 40),
            new Creature(3, "Yeti", "Nepal", 30)));
    // We'll add creatures to this list as needed but we'll start with this here
    private int counter = 4; // This is going to be used to track id values for the creatures (typically handled by db)


    // Get ALL
    // http://localhost:8080/creatures
//    @GetMapping // This links up with a GET request to allow this method to be executed when the GET request comes in
//    public List<Creature> getAllCreaturesHandler(){
//        return creatureList;
//    }

    // Update our Get All handler for the query parameter
    @GetMapping
    public List<Creature> getAllCreaturesHandler(@RequestParam(required = false) String country){
        // @RequestParam allows you to get the parameter from the URL string, by default it is required

        // If the string is null we return all values
        // otherwise return those in the proper country
        if (country == null){
            return creatureList;
        }

        return creatureList.stream().filter(creature -> {
            String creatureCountry = creature.getCountry().toLowerCase();
            return creatureCountry.equals(country.toLowerCase());
        }).toList();

    }

    // Get One
    // http://localhost:8080/creatures/{creatureId}
    @GetMapping("/{creatureId}")
    public ResponseEntity<Creature> getOneCreatureHandler(@PathVariable int creatureId){
        // This method needs to take in the id of the creature and use it to determine the creature that gets returned
        /*
        We specified the handler Mapping with @GetMapping and we took the path variable and matched it to an input
        parameter with @PathVariable
         */

        // Let's get the creature with the specific Id
        Optional<Creature> creature = creatureList.stream()
                .filter((c) -> c.getCreatureId() == creatureId)
                .findFirst();

        // What is an Optional? An Optional is a type of class that wraps around data that is possibly null
        // We'll see this a lot when we get to Spring Data but for now we'll use it like this

        // GOAL RIGHT NOW
        // If the resource exists we want to return it with a 200 status code, if the resource does not exist we
        // want to return a 404 status.

        // ResponseEntity
        // ExceptionHandling

        // What is a ResponseEntity? A ResponseEntity is an object that gives you full control over an HTTP Response
        // Status Code, Http Response Headers, Response Body

        // In the case the resource is present we'll return it, otherwise we will return a 404 (NOT FOUND)

        if (creature.isPresent()){
            // Creating a new response entity object
            return new ResponseEntity<>(creature.get(), HttpStatus.OK); // 200 Status code
        }

        // The ResponseEntity builder
        return ResponseEntity.status(404).build();
    }

    // Let's look at creating new creatures
    // This is a POST Request going to http://localhost:8080/creatures
    @PostMapping
    public ResponseEntity<Creature> createCreatureHandler(@RequestBody Creature newCreature){
        // I want to take in a Creature object an allow it to be created inside of the list
        // This object should come in through the method parameters
        // The @RequestBody annotation will attempt to convert the body passed into a creature object



        // Update the ID
        newCreature.setCreatureId(counter++);

        System.out.println(newCreature);

        // Append the creature to the list
        creatureList.add(newCreature);

        // Return the newCreature with a status code 201 (CREATED)
        return ResponseEntity.status(201).body(newCreature);
    }

    // After this we have a Put Mapping and a DELETE Mapping

    //Put Mapping -> Update Method
    // http://localhost:8080/creatures/{creatureId}

    @PutMapping("{creatureId}")
    public Creature updateCreatureHandler(@PathVariable int creatureId, @RequestBody Creature creature){

        // We need to look for the correct creature
        // If it does not exist we throw an exception
        Optional<Creature> possibleCreature = creatureList.stream()
                .filter(c -> c.getCreatureId() == creatureId)
                .findFirst();

        // The Optional class has nice methods for handling null values so we'll use them here
        // OrElseThrow will throw an exception if the optional is empty
        Creature existingCreature = possibleCreature.orElseThrow(
                ()-> new CreatureNotFoundException("No creature with id: " + creatureId));

        // If it does we update accordingly
        int index = creatureList.indexOf(existingCreature);
        // Replace the object
        creature.setCreatureId(existingCreature.getCreatureId());
        creatureList.set(index, creature);

        return creature;
    }


    // We have one more method and it is our DeleteMapping
    // http://localhost:8080/creatures/{creatureId}
    @DeleteMapping("{creatureId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // This is a 204 status showing the operation worked but there is no body
    public void deleteCreatureHandler(@PathVariable int creatureId){

        // Let's make sure the object exists and then remove the object if necessary
        Optional<Creature> possibleCreature = creatureList.stream()
                .filter(c -> c.getCreatureId() == creatureId)
                .findFirst();

        Creature existingCreature = possibleCreature.orElseThrow(
                () -> new CreatureNotFoundException("No Creature found with id: " + creatureId)
        );

        // Remove it from the list
        creatureList.remove(existingCreature);

    }

    // Exception Handling Method
    @ExceptionHandler(CreatureNotFoundException.class) // This method will be automatically called if the exception happens
    @ResponseStatus(HttpStatus.NOT_FOUND) // This specifies this method will return a 404 not found status
    public Map<String, String> creatureNotFoundExceptionHandler(CreatureNotFoundException e){
        return Map.of(
                "error", e.getMessage()
        );
    }


}
