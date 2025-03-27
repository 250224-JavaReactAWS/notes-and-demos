package com.revature.services;

import com.revature.models.Creature;
import com.revature.repos.CreatureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This class is a Spring bean and I want to inject a CreatureDAO (Another Spring bean)
public class CreatureService {

    private final CreatureDAO creatureDAO;

    @Autowired // Dependency Injection handled by Spring
    public CreatureService(CreatureDAO creatureDAO) {
        this.creatureDAO = creatureDAO;
    }

    public void testMethod(){
        // CRUD TEST
        // Insert/Update
        creatureDAO.save(new Creature()); // This is used to Insert or Update data

        // Get All
        creatureDAO.findAll();

        // Get one
        creatureDAO.findById(1);

        // Delete
        creatureDAO.delete(new Creature());
    }

    public Creature createCreature(Creature creature){
        return creatureDAO.save(creature);
    }

    public List<Creature> getAll(){
        return creatureDAO.findAll();
    }

    public Creature getById(int creatureId){
        return creatureDAO.findById(creatureId).get();
    }

    public List<Creature> getAllByCreatureType(String type){
        return creatureDAO.findAllByType(type);
    }

    public List<Creature> searchCreaturesByName(String keyword){
        return creatureDAO.searchByNameNative(keyword);
    }

    public List<Creature> searchCreaturesByName2(String keyword){
        return creatureDAO.findAllByNameContainsIgnoreCase(keyword);
    }

    public List<Creature> searchByHabitatAndMinAge(String habitatName, int minAge){
        return creatureDAO.findAllOldCreaturesByHabitat(habitatName, minAge);
    }

    public List<Creature> searchByHabitatAndMinAge2(String habitatName, int minAge){
        return creatureDAO.findAllByHabitat_NameAndAgeGreaterThanEqual(habitatName, minAge);
    }
}
