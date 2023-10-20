package com.example.Coursecontent.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Coursecontent.Entity.CourseContent;
import com.example.Coursecontent.Repository.CourseContentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseContentService {
	private final CourseContentRepository courseContentRepository;

	@Autowired
	public CourseContentService(CourseContentRepository courseContentRepository) {
		this.courseContentRepository = courseContentRepository;
	}

	public List<CourseContent> getAllCourseContents() {
		return courseContentRepository.findAll();
	}

	public CourseContent getCourseContentById(int courseId) {
		Optional<CourseContent> courseContent = courseContentRepository.findById(courseId);
		return courseContent.orElse(null);
	}

	public CourseContent createCourseContent(CourseContent courseContent) {
		return courseContentRepository.save(courseContent);
	}

	public CourseContent updateCourseContent(CourseContent courseContent) {
		if (courseContentRepository.existsById(courseContent.getCourseId())) {
			return courseContentRepository.save(courseContent);
		}
		return null;
	}

	public String deleteCourseContent(int courseId) {
		if (courseContentRepository.existsById(courseId)) {
			courseContentRepository.deleteById(courseId);
			return "Course content deleted successfully";
		} else {
			return "Course content not found";
		}
	}
}
