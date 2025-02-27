package com.revature.models;

/*
For Spring we leverage a lot of Annotations to take care of the work for us, we want to use them as much as we can
 */

import jakarta.persistence.*;

@Entity // This annotation says that we want to track this class in the database
@Table(name="biographies") // This allows us to create a table the way we want (config details)
public class Biography {

    /*
    The first thing we tackle when building a new application is the models of the data

    To build a model, we create a simple Java class that has a few things inside it
    Fields -> The necessary attributes we want to track in this piece of data
    Constructor(s) -> Allows us to build a Biography object
    Getters/Setters -> Allows us to control how and object gets updated

    This biography should hold some simple information:
    - name
    - fun fact
    - age
    - BiographyId
     */

    // The Annotations for the fields are the next most important
    @Id // This marks the field as a Primary Key (PK), it is unique and not null
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will automatically create a unique PK for my record
    private int biographyId;

    private String name;

    private String funFact;

    private int age;

    // We need getters and setters to update the data
    public int getBiographyId(){
       return this.biographyId;
    }

    public void setBiographyId(int biographyId) {
        this.biographyId = biographyId;
    }

    public String getName(){
        return this.name;
    }

    public String getFunFact(){
        return this.funFact;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setFunFact(String funFact){
        this.funFact = funFact;
    }

    public void setAge(int age){
        this.age = age;
    }

    // Constructors
    // The default constructor is a no-args constructor that makes a blank object
    public Biography(){
        // Doesn't initialize anything
    }

    public Biography(int biographyId, String name, String funFact, int age){
        this.biographyId = biographyId;
        this.name = name;
        this.funFact = funFact;
        this.age = age;
    }
}
