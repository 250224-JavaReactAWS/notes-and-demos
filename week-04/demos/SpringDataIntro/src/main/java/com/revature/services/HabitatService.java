package com.revature.services;

import com.revature.models.Habitat;
import com.revature.repos.HabitatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitatService {

    private final HabitatDAO habitatDAO;

    @Autowired
    public HabitatService(HabitatDAO habitatDAO) {
        this.habitatDAO = habitatDAO;
    }

    // Let's add in a couple of methods

    public Habitat createNewHabitat(String name){
        Habitat habitat = new Habitat(name);

        return habitatDAO.save(habitat);
    }
}
