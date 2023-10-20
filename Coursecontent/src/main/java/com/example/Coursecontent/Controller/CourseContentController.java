package com.example.Coursecontent.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Coursecontent.Entity.CourseContent;
import com.example.Coursecontent.Service.CourseContentService;

@Controller
@RequestMapping("/coursecontent")
public class CourseContentController {

    private final CourseContentService courseContentService;

    @Autowired
    public CourseContentController(CourseContentService courseContentService) {
        this.courseContentService = courseContentService;
    }

    @GetMapping("/list")
    public String listCourseContents(Model model) {
        List<CourseContent> courseContents = courseContentService.getAllCourseContents();
        model.addAttribute("courseContents", courseContents);
        model.addAttribute("courseContent", new CourseContent()); // Add an empty CourseContent object for the form
        return "coursecontent"; // Assuming "coursecontent" is your Thymeleaf template name
    }

    @PostMapping("/create")
    public String createCourseContent(@ModelAttribute CourseContent courseContent) {
        courseContentService.createCourseContent(courseContent);
        return "redirect:/coursecontent/list";
    }

    @GetMapping("/edit/{courseId}")
    public String editCourseContent(@PathVariable int courseId, Model model) {
        CourseContent courseContent = courseContentService.getCourseContentById(courseId);
        if (courseContent != null) {
            model.addAttribute("courseContent", courseContent);
            return "coursecontent";
        }
        return "redirect:/coursecontent/list";
    }

    @GetMapping("/delete/{courseId}")
    public String deleteCourseContent(@PathVariable int courseId) {
        courseContentService.deleteCourseContent(courseId);
        return "redirect:/coursecontent/list";
    }
}
