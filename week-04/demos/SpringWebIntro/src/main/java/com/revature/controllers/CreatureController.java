package com.revature.controllers;

import com.revature.models.Creature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     */

    private List<Creature> creatureList = List.of(
            new Creature(1, "Bigfoot", 40),
            new Creature(2, "Yeti", 30));
    // We'll add creatures to this list as needed but we'll start with this here
    private int counter = 1; // This is going to be used to track id values for the creatures (typically handled by db)


    // Get ALL
    // http://localhost:8080/creatures
    @GetMapping // This links up with a GET request to allow this method to be executed when the GET request comes in
    public List<Creature> getAllCreaturesHandler(){
        return creatureList;
    }

    // Get One
    // http://localhost:8080/creatures/{creatureId}
    @GetMapping("/{creatureId}")
    public Creature getOneCreatureHandler(@PathVariable int creatureId){
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
        if (creature.isPresent()){
            return creature.get();
        } else{
            return new Creature();
        }
    }


}
