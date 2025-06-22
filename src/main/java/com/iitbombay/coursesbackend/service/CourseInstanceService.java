package com.iitbombay.coursesbackend.service;

import com.iitbombay.coursesbackend.model.CourseInstance;
import com.iitbombay.coursesbackend.repository.CourseInstanceRepository;
import com.iitbombay.coursesbackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {
    
    @Autowired
    private CourseInstanceRepository courseInstanceRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    public CourseInstance createCourseInstance(CourseInstance courseInstance) throws IllegalArgumentException {
        // Validate that the course exists
        if (!courseRepository.existsById(courseInstance.getCourseId())) {
            throw new IllegalArgumentException("Course with ID '" + courseInstance.getCourseId() + "' does not exist");
        }
        
        return courseInstanceRepository.save(courseInstance);
    }
    
    public List<CourseInstance> getCourseInstancesByYearAndSemester(Integer year, Integer semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }
    
    public Optional<CourseInstance> getCourseInstance(String courseId, Integer year, Integer semester) {
        return courseInstanceRepository.findByCourseIdAndYearAndSemester(courseId, year, semester);
    }
    
    @Transactional
    public void deleteCourseInstance(String courseId, Integer year, Integer semester) throws IllegalArgumentException {
        Optional<CourseInstance> instance = courseInstanceRepository.findByCourseIdAndYearAndSemester(courseId, year, semester);
        if (instance.isEmpty()) {
            throw new IllegalArgumentException("Course instance not found");
        }
        
        courseInstanceRepository.deleteByCourseIdAndYearAndSemester(courseId, year, semester);
    }
}

