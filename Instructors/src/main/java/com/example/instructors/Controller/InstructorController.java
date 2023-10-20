package com.example.instructors.Controller;

import com.example.instructors.Entity.Instructor;
import com.example.instructors.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

	private final InstructorRepository instructorRepository;

	@Autowired
	public InstructorController(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}

	@GetMapping("/list")
	public String listInstructors(Model model) {
		List<Instructor> instructors = instructorRepository.findAll();
		model.addAttribute("instructors", instructors);
		model.addAttribute("instructor", new Instructor()); // Add an empty Instructor object for the form
		return "instructor";
	}

	@PostMapping("/create")
	public String createInstructor(@ModelAttribute Instructor instructor) {
		instructorRepository.save(instructor);
		return "redirect:/instructors/list";
	}

	@GetMapping("/editInstructor/{instructorId}")
	public String editInstructor(@PathVariable Long instructorId, Model model) {
		Optional<Instructor> instructor = instructorRepository.findById(instructorId);
		if (instructor.isPresent()) {
			model.addAttribute("instructor", instructor.get());
			return "instructor";
		}
		return "redirect:/instructors/list";
	}

	@GetMapping("/deleteInstructor/{instructorId}")
	public String deleteInstructor(@PathVariable Long instructorId) {
		Optional<Instructor> instructor = instructorRepository.findById(instructorId);
		if (instructor.isPresent()) {
			instructorRepository.delete(instructor.get());
		}
		return "redirect:/instructors/list";
	}
}
