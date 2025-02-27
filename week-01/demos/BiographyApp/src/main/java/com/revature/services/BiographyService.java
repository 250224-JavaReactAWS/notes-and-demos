package com.revature.services;

import com.revature.models.Biography;
import com.revature.repos.BiographyDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Stereotype annotation
public class BiographyService {

    /*
    The service layer of your application is in charge of BUSINESS LOGIC.

    It leverages methods from the BiographyDAO to manipulate the data inside of the database
    In this class we'll need to inject in the BiographyDAO to have access to the methods
     */

    private BiographyDAO biographyDAO;

    // Constructor taking in the DAO/Repo layer
    public BiographyService(BiographyDAO biographyDAO){
        this.biographyDAO = biographyDAO;
    }

    // Now we'll create methods that use the DAO layer methods to update or create new data

    // TODO Create a new Biography
    public Biography createNewBiography(Biography bio){
        // This method is in charge of creating the new pieces of data
        // It should verify anything that needs to be validated before saving the data

        if (bio.getAge() <= 0){
            // If the age is 0 or less I won't save the bio
            return null;
        }

        Biography savedBiography = biographyDAO.save(bio);

        return savedBiography;
    }

    // TODO Get all existing biographies
    // Get methods typically don't have a lot of validation so these will be simple
    public List<Biography> getAllBiographies(){
        return biographyDAO.findAll();
    }

    // TODO Get a single biography
    // Here we want to get a single biography object by its PK (Primary Key)
    public Biography getBioById(int biographyId){
        return biographyDAO.getReferenceById(biographyId);
    }

    // TODO Get all biographies with the same name
    public List<Biography> getAllByName(String name){
        return biographyDAO.getAllByName(name);
    }
}
