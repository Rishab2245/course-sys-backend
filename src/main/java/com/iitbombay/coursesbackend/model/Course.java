package com.iitbombay.coursesbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    
    @Id
    @NotBlank(message = "Course ID is required")
    @Column(name = "course_id")
    private String courseId;
    
    @NotBlank(message = "Title is required")
    @Column(name = "title")
    private String title;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @ElementCollection
    @CollectionTable(name = "course_prerequisites", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "prerequisite_id")
    private List<String> prerequisites;
    
    // Default constructor
    public Course() {}
    
    // Constructor
    public Course(String courseId, String title, String description, List<String> prerequisites) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.prerequisites = prerequisites;
    }
    
    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }
    
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<String> getPrerequisites() {
        return prerequisites;
    }
    
    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }
}

