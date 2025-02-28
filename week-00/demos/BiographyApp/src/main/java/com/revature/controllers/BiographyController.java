package com.revature.controllers;

import com.revature.models.Biography;
import com.revature.services.BiographyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
The main annotations needed for our Controller layer are as follows
@RestController
@RequestMapping -> Controls the top level of our request endpoints
@Get/Post/Put/DeleteMapping
@RequestBody
@PathVariable
@RequestParam

All HTTP Requests have a few things with them, one of the most important is the HTTP Verb/Method. This is GET, POST,
PUT, PATCH, DELETE and they describe how you plan to interact with the data. The next most important thing is the
request body, which is the information sent with the HTTP request. This is the piece of data we plan to have stored in
the database
 */

@RestController // Stereotype Annotation
@RequestMapping("bios") // This means every request starts with http://localhost:8080/bios
public class BiographyController {
    /*
    The controller layer of the application is in charge of Web Traffic. As HTTP requests come in, they go directly
    to this class which processes the request and calls the appropriate Service layer method

    We need access to the service layer, so we'll add it as part of a constructor
     */

    private BiographyService biographyService;

    // Constructor
    public BiographyController(BiographyService biographyService){
        this.biographyService = biographyService;
    }

    /*
    All of these requests are going to fall under an HTTP endpoint
    http://localhost:8080/bios
    http://localhost:8080/bios/bioId
    http://localhost:8080/bios/name?name=name

     */

    // TODO Create a New Biography
    // This is an HTTP POST Method
    @PostMapping
    public Biography createBiographyHandler(@RequestBody Biography bio){
        return this.biographyService.createNewBiography(bio);

        // If you're familiar with HTTP we can make this more robust by adding different status codes but we'll skip
        // that for now
    }

    // Todo Get All Biographies
    @GetMapping
    // http://localhost:8080/bios
    public List<Biography> getAllBiosHandler(){
        return this.biographyService.getAllBiographies();
    }

    // TODO Get Biographies By Id
    // We can't share the same endpoint as before so we'll add on some new endpoints to the controller
    // http://localhost:8080/bios/1
    // http://localhost:8080/bios/2
    // http://localhost:8080/bios/3
    @GetMapping("/{bioId}")
    public Biography getBioByIdHandler(@PathVariable(name = "bioId") int bioId){
        return this.biographyService.getBioById(bioId);
    }

    // Todo Get All Bios by name
    // This method will FILTER all of the biographies and get the ones with the same name
    // http://localhost:8080/bios/name?name=bryan
    // http://localhost:8080/bios/name?name=criss
    // http://localhost:8080/bios/name?name=john
    @GetMapping("name")
    public List<Biography> getAllBiosByName(@RequestParam String name){
        return this.biographyService.getAllByName(name);
    }
}
