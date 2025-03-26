package com.revature.models;

public class Creature {

    /*
    This class is a model class, it's the same as we've seen time and time again. We define different fields and then
    constructors, getters and setters. This class is just a data model it is NOT a Spring bean

    This class is for a Creature model so it's used to describe different mythical creatures in the world
    Bigfoot
    Yeti
    Loch Ness Monster
    Chupacabra

     */

    private int creatureId;

    private String name;

    private String country;

    private int age;

    // THE NO ARGS CONSTRUCTOR IS REQUIRED
    // We need to add this for Jackson Databind, that's the dependency that converts between Java Objects and JSON
    public Creature() {
    }

    public Creature(int creatureId, String name, String country, int age) {
        this.creatureId = creatureId;
        this.name = name;
        this.country = country;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
