package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
        System.out.println("sadlsaasdasd");
//        userService.addUser(new User("asdasd",'m',"aslkdasd@ad.hell"));
        return "users";
    }

    @GetMapping(value = "/good_bye")
    public String showGoodBye() {
        return "good_bye";
    }

    @GetMapping(value = "/add_user")
    public String showAddUser(Model model, String name, String surname) {
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        return "add_user";
    }
    @PostMapping(value = "/user", consumes = {"*/*"})
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        System.out.println(user);
        return "users";
    }
}

