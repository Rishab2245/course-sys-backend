package com.iitbombay.coursesbackend.repository;

import com.iitbombay.coursesbackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    
    @Query("SELECT c FROM Course c JOIN c.prerequisites p WHERE p = :courseId")
    List<Course> findCoursesWithPrerequisite(@Param("courseId") String courseId);
}

