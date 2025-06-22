package com.iitbombay.coursesbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "course_instances")
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course ID is required")
    @Column(name = "course_id")
    private String courseId;

    @NotNull(message = "Year is required")
    @Column(name = "academic_year") // ✅ renamed from "year" to avoid SQL keyword conflict
    private Integer year;

    @NotNull(message = "Semester is required")
    @Column(name = "semester")
    private Integer semester;

    // Default constructor
    public CourseInstance() {}

    // Constructor
    public CourseInstance(String courseId, Integer year, Integer semester) {
        this.courseId = courseId;
        this.year = year;
        this.semester = semester;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
