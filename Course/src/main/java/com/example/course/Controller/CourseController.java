package com.example.course.Controller;

import com.example.course.Entity.Course;
import com.example.course.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private final CourseRepository courseRepository;

	@Autowired
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@GetMapping("/list")
	public String listCourses(Model model) {
		List<Course> courses = courseRepository.findAll();
		model.addAttribute("courses", courses);
		model.addAttribute("course", new Course()); // Add an empty Course object for the form
		return "course";
	}

	@PostMapping("/create")
	public String createCourse(@ModelAttribute Course course) {
		courseRepository.save(course);
		return "redirect:/courses/list";
	}

	@GetMapping("/editCourse/{course_id}")
	public String editCourse(@PathVariable Long course_id, Model model) {
		Optional<Course> course = courseRepository.findById(course_id);
		if (course.isPresent()) {
			model.addAttribute("course", course.get());
			return "course";
		}
		return "redirect:/courses/list";
	}

	@GetMapping("/deleteCourse/{course_id}")
	public String deleteCourse(@PathVariable Long course_id) {
		Optional<Course> course = courseRepository.findById(course_id);
		if (course.isPresent()) {
			courseRepository.delete(course.get());
		}
		return "redirect:/courses/list";
	}
}
