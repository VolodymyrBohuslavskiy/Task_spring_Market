package com.example.demo2.controllers;

import com.example.demo2.dao.EmailDAO;
import com.example.demo2.dao.UserDAO;
import com.example.demo2.models.Email;
import com.example.demo2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class mainController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    EmailDAO emailDAO;

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("work 1");

        return "index";
    }

    @PostMapping("/")
    public String addUser(
            User user,
            @RequestParam String email,
            Model model) {
        System.out.println("work 2");

        Email email1 = new Email(email,user);

        emailDAO.save(email1);
        List<Email> emails = new ArrayList<>();
        emails.add(email1);

        user.setEmails(emails);
        userDAO.save(user);


        model.addAttribute("all", "Recorded: " + user.getName() + " " + user.getSurname()+" "+user.getEmails());

        List<User> allList = userDAO.findAll();
        model.addAttribute("allList", allList);

        return "redirect:/";
    }

    @GetMapping("/nan")
    public String nan(Model model) {
        final List<User> users = userDAO.findAll();
        model.addAttribute("w", users);
        return "thymyleaf";
    }

    @GetMapping("/user-{id}")
    public String usEr(@PathVariable("id") int id, Model model) {
        Optional<Email> emails = emailDAO.findById(id);
        model.addAttribute("emails",emails);
        model.addAttribute("user", userDAO.findById(id));
        return "single";
    }

}
