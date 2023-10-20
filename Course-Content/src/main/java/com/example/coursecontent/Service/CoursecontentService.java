package com.example.coursecontent.Service;

import com.example.coursecontent.Entity.CourseContent;
import com.example.coursecontent.Repository.CoursecontentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursecontentService {

	private final CoursecontentRepository coursecontentRepository;

	@Autowired
	public CoursecontentService(CoursecontentRepository coursecontentRepository) {
		this.coursecontentRepository = coursecontentRepository;
	}

	public List<CourseContent> getAllCourses() {
		return coursecontentRepository.findAll();
	}

	public CourseContent getCourseById(int courseId) {
		Optional<CourseContent> courseContent = coursecontentRepository.findById(courseId);
		return courseContent.orElse(null);
	}

	public CourseContent createCourse(CourseContent courseContent) {
		return coursecontentRepository.save(courseContent);
	}

	public CourseContent updateCourse(CourseContent courseContent) {
		if (coursecontentRepository.existsById(courseContent.getCourseId())) {
			return coursecontentRepository.save(courseContent);
		}
		return null;
	}

	public String deleteCourse(int courseId) {
		if (coursecontentRepository.existsById(courseId)) {
			coursecontentRepository.deleteById(courseId);
			return "Course deleted successfully";
		} else {
			return "Course not found";
		}
	}
}
