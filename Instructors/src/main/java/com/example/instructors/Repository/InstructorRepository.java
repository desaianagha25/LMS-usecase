package com.example.instructors.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.instructors.Entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    
}
