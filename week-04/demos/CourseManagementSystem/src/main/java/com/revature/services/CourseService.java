package com.revature.services;

import com.revature.repos.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    // TODO Create A course

    // TODO Get all courses

    // TODO Get a single course

    // Todo Enroll in a course
}
