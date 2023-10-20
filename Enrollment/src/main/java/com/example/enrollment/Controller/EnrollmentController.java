package com.example.enrollment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.enrollment.Entity.Enrollment;
import com.example.enrollment.Repository.EnrollmentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @GetMapping("/")
    public String index1() {
        return "Hello to Spring Boot";
    }

    @PostMapping("/savingData")
    public Enrollment saveData(@RequestBody Enrollment enrollment) {
        enrollmentRepository.saveAll(enrollment);
        return enrollment;
    }

    @GetMapping("/getAllEnrollments")
    public List<Enrollment> getAll() {
		return enrollmentRepository.findAll();
    }

    @DeleteMapping("/deleteEnrollment/{enrollmentId}")
    public String deleteEnrollment(@PathVariable Long enrollmentId) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(enrollmentId);
        if (enrollment.isPresent()) {
            enrollmentRepository.deleteById(enrollment.get());
            return "Enrollment deleted successfully";
        } else {
            return "Enrollment not found";
        }
    }

    @PutMapping("/updateData")
    public Enrollment updateEnrollment(@RequestBody Enrollment enrollment) {
        enrollmentRepository.saveAll(enrollment);
        return enrollment;
    }

    @GetMapping("/getEnrollment/{enrollmentId}")
    public Enrollment getEnrollment(@PathVariable Long enrollmentId) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(enrollmentId);
        return enrollment.orElse(null);
    }
}
