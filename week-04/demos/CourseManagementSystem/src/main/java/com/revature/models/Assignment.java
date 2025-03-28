package com.revature.models;

import jakarta.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignmentId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Assignment() {
    }

    public Assignment(int assignmentId, String name, Course course) {
        this.assignmentId = assignmentId;
        this.name = name;
        this.course = course;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
