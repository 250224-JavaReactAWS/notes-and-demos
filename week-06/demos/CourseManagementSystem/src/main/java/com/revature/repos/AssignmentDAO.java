package com.revature.repos;

import com.revature.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentDAO extends JpaRepository<Assignment, Integer> {
}
