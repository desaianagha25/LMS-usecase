package com.example.course.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.Entity.Course;
import com.example.course.Repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.orElse(null);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        if (courseRepository.existsById(courseId)) {
            updatedCourse.setCourse_id(courseId);
            return courseRepository.save(updatedCourse);
        }
        return null;
    }

    public String deleteCourse(Long courseId) {
        if (courseRepository.existsById(courseId)) {
            courseRepository.deleteById(courseId);
            return "Course deleted successfully";
        } else {
            return "Course not found";
        }
    }

	
	}

