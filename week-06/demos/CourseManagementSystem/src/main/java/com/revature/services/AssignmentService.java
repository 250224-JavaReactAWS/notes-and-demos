package com.revature.services;

import com.revature.repos.AssignmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    private final AssignmentDAO assignmentDAO;

    @Autowired
    public AssignmentService(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    // TODO Create Assignment

    // TODO Get All Assignments for a course
}
