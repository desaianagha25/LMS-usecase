package com.example.coursecontent.Controller;

import java.io.IOException;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.coursecontent.Entity.CourseContent;
import com.example.coursecontent.Service.CoursecontentService;

@Controller
@RequestMapping("/coursecontent")
public class CoursecontentController {

    private final CoursecontentService coursecontentService;

    @Autowired
    public CoursecontentController(CoursecontentService coursecontentService) {
        this.coursecontentService = coursecontentService;
    }

    @GetMapping("/list")
    public String listCourses(Model model) {
        java.util.List<CourseContent> courseContents = coursecontentService.getAllCourses();
        model.addAttribute("courses", courseContents);
        return "coursecontent";
    }

    @PostMapping("/create")
    public String createCourse(@ModelAttribute CourseContent courseContent) {
        coursecontentService.createCourse(courseContent);
        return "redirect:/coursecontent/list";
    }

    @GetMapping("/get/{courseId}")
    public String getCourse(@PathVariable int courseId, Model model) {
        CourseContent courseContent = coursecontentService.getCourseById(courseId);
        model.addAttribute("course", courseContent);
        return "coursecontent";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute CourseContent courseContent) {
        coursecontentService.updateCourse(courseContent);
        return "redirect:/coursecontent/list";
    }

    @DeleteMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable int courseId) {
        coursecontentService.deleteCourse(courseId);
        return "redirect:/coursecontent/list";
    }

    @PostMapping("/uploadPDF/{courseId}")
    public String uploadPDF(@PathVariable int courseId, @RequestParam("file") MultipartFile file) {
        CourseContent courseContent = coursecontentService.getCourseById(courseId);
        if (courseContent != null) {
            try {
                courseContent.setPdfData(file.getBytes());
                courseContent.setFileName(file.getOriginalFilename());
                coursecontentService.updateCourse(courseContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/coursecontent/list";
    }

    @GetMapping("/viewCourseContent")
    public String viewCourseContent(Model model) {
        CourseContent courseContent = new CourseContent();
        model.addAttribute("courseContent", courseContent);
        return "coursecontent"; // Your view name
    }

}
