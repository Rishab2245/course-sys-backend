package com.iitbombay.coursesbackend.controller;

import com.iitbombay.coursesbackend.model.CourseInstance;
import com.iitbombay.coursesbackend.service.CourseInstanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instances")
@CrossOrigin(origins = "*")
public class CourseInstanceController {
    
    @Autowired
    private CourseInstanceService courseInstanceService;
    
    @PostMapping
    public ResponseEntity<?> createCourseInstance(@Valid @RequestBody CourseInstance courseInstance) {
        try {
            CourseInstance createdInstance = courseInstanceService.createCourseInstance(courseInstance);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdInstance);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getCourseInstancesByYearAndSemester(
            @PathVariable Integer year, 
            @PathVariable Integer semester) {
        List<CourseInstance> instances = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }
    
    @GetMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<CourseInstance> getCourseInstance(
            @PathVariable Integer year, 
            @PathVariable Integer semester, 
            @PathVariable String courseId) {
        Optional<CourseInstance> instance = courseInstanceService.getCourseInstance(courseId, year, semester);
        if (instance.isPresent()) {
            return ResponseEntity.ok(instance.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<?> deleteCourseInstance(
            @PathVariable Integer year, 
            @PathVariable Integer semester, 
            @PathVariable String courseId) {
        try {
            courseInstanceService.deleteCourseInstance(courseId, year, semester);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

