package com.revature.services;

import com.revature.models.Course;
import com.revature.repos.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    // TODO Create A course
    public Course createCourse(Course courseToBeCreated){
        return courseDAO.save(courseToBeCreated);
    }


    // TODO Get all courses
    public List<Course> getAllCourses(){
        return courseDAO.findAll();
    }

    // TODO Get a single course
    public Optional<Course> getCourseById(int courseId){
        return courseDAO.findById(courseId);
    }


}
