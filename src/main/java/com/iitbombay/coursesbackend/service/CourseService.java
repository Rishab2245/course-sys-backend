package com.iitbombay.coursesbackend.service;

import com.iitbombay.coursesbackend.model.Course;
import com.iitbombay.coursesbackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    public Optional<Course> getCourseById(String courseId) {
        return courseRepository.findById(courseId);
    }
    
    public Course createCourse(Course course) throws IllegalArgumentException {
        // Validate prerequisites exist
        if (course.getPrerequisites() != null) {
            for (String prerequisiteId : course.getPrerequisites()) {
                if (!courseRepository.existsById(prerequisiteId)) {
                    throw new IllegalArgumentException("Prerequisite course with ID '" + prerequisiteId + "' does not exist");
                }
            }
        }
        return courseRepository.save(course);
    }
    
    public Course updateCourse(String courseId, Course updatedCourse) throws IllegalArgumentException {
        if (!courseRepository.existsById(courseId)) {
            throw new IllegalArgumentException("Course with ID '" + courseId + "' does not exist");
        }
        
        // Validate prerequisites exist
        if (updatedCourse.getPrerequisites() != null) {
            for (String prerequisiteId : updatedCourse.getPrerequisites()) {
                if (!courseRepository.existsById(prerequisiteId)) {
                    throw new IllegalArgumentException("Prerequisite course with ID '" + prerequisiteId + "' does not exist");
                }
            }
        }
        
        updatedCourse.setCourseId(courseId);
        return courseRepository.save(updatedCourse);
    }
    
    public void deleteCourse(String courseId) throws IllegalArgumentException {
        if (!courseRepository.existsById(courseId)) {
            throw new IllegalArgumentException("Course with ID '" + courseId + "' does not exist");
        }
        
        // Check if course is a prerequisite for other courses
        List<Course> dependentCourses = courseRepository.findCoursesWithPrerequisite(courseId);
        if (!dependentCourses.isEmpty()) {
            throw new IllegalStateException("Cannot delete course '" + courseId + "' as it is a prerequisite for other courses");
        }
        
        courseRepository.deleteById(courseId);
    }
}

