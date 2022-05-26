package com.bratish971.CRUDappBoot.controller;

import com.bratish971.CRUDappBoot.dao.UserRepository;
import com.bratish971.CRUDappBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "users/show";
    }

    @GetMapping("/new")
    public String createNew(@ModelAttribute("user") User user) {
        return "newuser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userRepository.save(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user , @PathVariable("id") long id) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userRepository.delete(userRepository.findById(id).get());
        return "redirect:/users";
    }
}
