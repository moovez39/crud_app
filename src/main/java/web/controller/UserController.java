package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

import javax.validation.Valid;


@Controller
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userServiceImpl.getUsers());
        return "users";
    }


    @GetMapping(value = "/new_user")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new_user";
    }

    @GetMapping(value = "/edit_user")
    public String editUser(@RequestParam(name = "") int id, Model model) {
        model.addAttribute("user", userServiceImpl.findUser(id));
        return "edit_user";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute("user")  @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "new_user";
        }
        userServiceImpl.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @RequestParam(name = "id") int id) {
        if(bindingResult.hasErrors()){
            return "edit_user";
        }
        userServiceImpl.editUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("user") User user, @RequestParam(name = "id") int id) {
        System.out.println("test");
        userServiceImpl.removeUser(id);
        return "redirect:/";
    }
}

