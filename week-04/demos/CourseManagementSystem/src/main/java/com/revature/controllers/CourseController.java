package com.revature.controllers;

import com.revature.exceptions.ForbiddenActionException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.models.Course;
import com.revature.models.Role;
import com.revature.services.CourseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("courses") // http://localhost:8080/courses
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // TODO Create a course
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourseHandler(@RequestBody Course course, HttpSession session){
        // I Need to make sure the user is logged in

        if (session.getAttribute("userId") == null){
            throw new UnauthenticatedException("User is not authenticated");
        }

        // I need to make sure the role of the user is a teacher
        if (session.getAttribute("role") != Role.TEACHER){
            throw new ForbiddenActionException("You must be a teacher to access this");
        }

        // I can create the course
        return courseService.createCourse(course);
    }

    // TODO get all courses
    @GetMapping
    public List<Course> getAllCoursesHandler(){
        return courseService.getAllCourses();
    }

    // TODO get a single course
    @GetMapping("{courseId}") // http://localhost:8080/courses/{courseId}
    public Course getCourseHandler(@PathVariable int courseId){

        return courseService.getCourseById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("No course with id: " + courseId));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> resourceNotFoundHandler(ResourceNotFoundException e){
        return Map.of(
                "error", e.getMessage()
        );
    }
}
