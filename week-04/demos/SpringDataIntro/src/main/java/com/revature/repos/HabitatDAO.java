package com.revature.repos;

import com.revature.models.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatDAO extends JpaRepository<Habitat, Integer> {
}
