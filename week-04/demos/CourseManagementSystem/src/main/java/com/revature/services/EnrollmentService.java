package com.revature.services;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Course;
import com.revature.models.User;
import com.revature.repos.CourseDAO;
import com.revature.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class EnrollmentService {

    private final UserDAO userDAO;

    private final CourseDAO courseDAO;

    @Autowired
    public EnrollmentService(UserDAO userDAO, CourseDAO courseDAO) {
        this.userDAO = userDAO;
        this.courseDAO = courseDAO;
    }

    // Todo view enrollments by user id
    public List<Course> getEnrolledCoursesByStudent(int userId){
        return userDAO.getCoursesByUserId(userId);
    }


    // Todo Enroll in a course
    @Transactional // Marks this method as needed a transaction for execution
    public Course enrollInCourseHandler(int userId, int courseId){
        // We need to make sure the user exists
        User returnedUser = userDAO.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("No User found with id: " + userId));

        Course returnedCourse = courseDAO.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("No Course found with id: " + courseId));

        Set<Course> enrollments = returnedUser.getCourses();
        enrollments.add(returnedCourse);
        returnedUser.setCourses(enrollments);
        userDAO.save(returnedUser);

        return returnedCourse;
    }
}
