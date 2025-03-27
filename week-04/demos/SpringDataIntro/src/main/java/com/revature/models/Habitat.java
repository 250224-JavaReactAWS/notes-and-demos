package com.revature.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "habitats")
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int habitatId;

    @Column(nullable = false, unique = true)
    private String name;

    // We can also include a List of the creatures that reside here
    // Bidirectional Relationship Vs Unidirectional
    // This allows for the classes to be mapped together based off how they're defined in the Creature Class
    // The CascadeType.ALL and orphanRemove = true helps remove orphaned records if we delete a habitat
    @OneToMany(mappedBy = "habitat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Creature> creatures;

    public Habitat() {
        this.creatures = new ArrayList<>();
    }

    public Habitat(String name) {
        this.name = name;
        this.creatures = new ArrayList<>();
    }

    public Habitat(int habitatId, String name, List<Creature> creatures) {
        this.habitatId = habitatId;
        this.name = name;
        this.creatures = creatures;
    }

    public int getHabitatId() {
        return habitatId;
    }

    public void setHabitatId(int habitatId) {
        this.habitatId = habitatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }


}
