package com.example.course.Repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	//void createCourse(Course course);

	 @SuppressWarnings("unchecked")
	Course save(Course course);

	

	

}
