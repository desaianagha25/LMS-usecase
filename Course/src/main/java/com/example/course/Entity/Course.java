package com.example.course.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long course_id;

	private String course_name;
	private String description;

	// Constructors, getters, and setters

	public Course() {
	}

	public Course(String course_name, String description) {
		this.course_name = course_name;
		this.description = description;
	}

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() { // Change the getter name
		return course_name;
	}

	public void setCourse_name(String course_name) { // Change the setter name
		this.course_name = course_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
