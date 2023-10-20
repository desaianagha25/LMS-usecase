package com.example.coursecontent.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coursecontent.Entity.CourseContent;

@Repository
public interface CoursecontentRepository extends JpaRepository<CourseContent, Integer> {
	
	
	
	List<CourseContent> findByCourseName(String courseName);
}


