package com.example.instructors.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.instructors.Entity.Instructor;
import com.example.instructors.Repository.InstructorRepository;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long instructorId) {
        return instructorRepository.findById(instructorId).orElse(null);
    }

    public void deleteInstructor(Long instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    public Instructor updateInstructor(Long instructorId, Instructor updatedInstructor) {
        if (instructorRepository.existsById(instructorId)) {
            updatedInstructor.setInstructorId(instructorId);
            return instructorRepository.save(updatedInstructor);
        }
        return null;
    }
}
