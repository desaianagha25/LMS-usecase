package com.example.Coursecontent.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Coursecontent.Entity.CourseContent;

@Repository
public interface CourseContentRepository extends JpaRepository<CourseContent, Integer> {
}
