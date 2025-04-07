package com.revature.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
//@Data // This is a lombok annotation which combines most of the ones we've seen so far
//@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assignment> assignments;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private Set<User> students;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
