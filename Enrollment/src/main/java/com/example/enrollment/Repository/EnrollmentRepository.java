package com.example.enrollment.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.enrollment.Entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	
	



	void deleteById(Enrollment enrollment);

	void saveAll(Enrollment enrollment);

	List<Enrollment> findAll();

	

	

	
}


