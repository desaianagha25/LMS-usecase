package com.example.Coursecontent.Entity;




import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class CourseContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Lob
    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "pdf_data")
    private byte[] pdfData;

    @Column(name = "file_name")
    private String fileName;

    // Constructors
    public CourseContent() {
        // Default constructor
    }

    // Parameterized constructor
    public CourseContent(String courseName, String description, byte[] pdfData, String fileName) {
        this.courseName = courseName;
        this.description = description;
        this.pdfData = pdfData;
        this.fileName = fileName;
    }

    // Getters and Setters
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
