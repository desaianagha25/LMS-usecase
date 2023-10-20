package com.example.user.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.user.Entity.User;
import com.example.user.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User()); // Add an empty User object for the form
        return "user";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user"; // Return the form page with error messages
        }
        userService.createUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/editUser/{user_id}")
    public String editUser(@PathVariable Long user_id, Model model) {
        User user = userService.getUserById(user_id);
        if (user != null) {
            model.addAttribute("user", user);
            return "user";
        }
        return "redirect:/user/list";
    }

    @GetMapping("/deleteUser/{user_id}")
    public String deleteUser(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
        return "redirect:/user/list";
    }
}

	// ... (other methods)

