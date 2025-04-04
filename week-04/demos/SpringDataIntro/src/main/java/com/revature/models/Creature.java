package com.revature.models;

import jakarta.persistence.*;

@Entity // This marks this class to the JPA and tells it that it should be tracked in the Database
@Table(name = "creatures") // This is an annotation we can use to provide configuration info for the table itself
public class Creature {

    /*
    This example is similar to the one we had yesterday, this will include various creatures and they will have a
    M:1 relationship with a Habitat. Many Creatures live in one habitat. Before we used spring the fields of this class
    would like:
        creatureId
        name
        type
        age
        habitatId

    Now it is similar but slightly different when it comes to the relationship
        creatureId
        name
        type
        age
        Habitat (Object)

    We need to add on some annotations in this class to define how the data should be stored. These come from the JPA

    Since we marked this class with @Entity, it will be able to read in the different columns and add the values to the
    table columns, but we need to specify extra info (like a PK, autogenerated fields, any constraints)
     */

    @Id // This marks this field as a Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This allows for us to generate a unique ID value
    private int creatureId;

    @Column(unique = true, nullable = false) // This provides config information on a column level
    private String name;

    @Column(nullable = false)
    private String type;

    private int age;

    // This relates to another table so we need to use a relationship annotation
    // OneToOne, OneToMany, ManyToOne, ManyToMany
    @ManyToOne // This means many creatures to one habitat
    @JoinColumn(name = "habitat_id") // Annotation for defining the column that joins the tables
    private Habitat habitat;


    public Creature() {
    }

    public Creature(String name, String type, int age, Habitat habitat) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.habitat = habitat;
    }

    public Creature(int creatureId, String name, String type, int age, Habitat habitat) {
        this.creatureId = creatureId;
        this.name = name;
        this.type = type;
        this.age = age;
        this.habitat = habitat;
    }

    public int getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(int creatureId) {
        this.creatureId = creatureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "creatureId=" + creatureId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", habitat=" + habitat +
                '}';
    }
}
