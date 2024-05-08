package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping(value = "/good_bye")
    public String showGoodBye() {
        return "good_bye";
    }

    @GetMapping(value = "/new_user")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }
    @PostMapping("/user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        System.out.println(user);
        return "redirect:/";
    }
}

