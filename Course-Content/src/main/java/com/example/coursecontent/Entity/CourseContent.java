package com.example.coursecontent.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;



@Entity
public class CourseContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;

	private String courseName;
	private String description;

	@Lob
	private byte[] pdfData;

	private String fileName;

	public CourseContent() {
		// Default constructor
	}

	public CourseContent(String courseName, String description, byte[] pdfData, String fileName) {
		this.courseName = courseName;
		this.description = description;
		this.pdfData = pdfData;
		this.fileName = fileName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPdfData() {
		return pdfData;
	}

	public void setPdfData(byte[] pdfData) {
		this.pdfData = pdfData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
