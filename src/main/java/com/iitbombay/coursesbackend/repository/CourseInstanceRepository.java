package com.iitbombay.coursesbackend.repository;

import com.iitbombay.coursesbackend.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    
    List<CourseInstance> findByYearAndSemester(Integer year, Integer semester);
    
    Optional<CourseInstance> findByCourseIdAndYearAndSemester(String courseId, Integer year, Integer semester);
    
    void deleteByCourseIdAndYearAndSemester(String courseId, Integer year, Integer semester);
}

