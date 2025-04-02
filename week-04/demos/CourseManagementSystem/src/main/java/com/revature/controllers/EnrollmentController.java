package com.revature.controllers;

import com.revature.exceptions.ForbiddenActionException;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.models.Course;
import com.revature.models.Role;
import com.revature.services.EnrollmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enrollments")
@CrossOrigin(origins = "http://127.0.0.1:5500") // This allows requests to come in from http://localhost:5500
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // GET Users enrollments
    @GetMapping
    public List<Course> getEnrollmentsHandler(HttpSession session){
        // We need to make sure the user is autheticated and a student
        if (session.getAttribute("userId") == null){
            throw new UnauthenticatedException("User is not authenticated");
        }

        // I need to make sure the role of the user is a student
        if (session.getAttribute("role") != Role.STUDENT){
            throw new ForbiddenActionException("You must be a student to access this");
        }

        return enrollmentService.getEnrolledCoursesByStudent((Integer) session.getAttribute("userId"));

    }

    // Enroll in course
    @PostMapping("{courseId}") // POST to http://localhost:8080/enrollments/{courseId}
    public Course newEnrollmentHandler(@PathVariable int courseId, HttpSession session){
        if (session.getAttribute("userId") == null){
            throw new UnauthenticatedException("User is not authenticated");
        }

        // I need to make sure the role of the user is a student
        if (session.getAttribute("role") != Role.STUDENT){
            throw new ForbiddenActionException("You must be a student to access this");
        }

        return enrollmentService.enrollInCourseHandler( (Integer) session.getAttribute("userId"), courseId);
    }
}
