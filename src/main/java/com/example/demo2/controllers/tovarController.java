package com.example.demo2.controllers;

import com.example.demo2.dao.tovarDAO;
import com.example.demo2.models.tovar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class tovarController {
    @Autowired
    tovarDAO tovarDAO;

    @GetMapping("/tovar")
    public String getTovarPage(Model model) {
        List<tovar> all = tovarDAO.findAll();
        model.addAttribute("all", all);
        return "tovar";
    }

    @GetMapping("/tovar_1000")
    public String show1000(Model model) {
        List<tovar> all = tovarDAO.byPrice(1000);
        model.addAttribute("all", all);
        return "tovar";
    }

    @GetMapping("/tovar_2000")
    public String show2000(Model model) {
        List<tovar> all = tovarDAO.byPrice(2000);
        model.addAttribute("all", all);
        return "tovar";
    }

    @GetMapping("/tovar_ten")
    public String tovar_ten(Model model) {

        List<tovar> all = tovarDAO.findAll(Sort.by("id"));
        model.addAttribute("all", all.subList(all.size() - 10, all.size()));
        return "tovar";
    }

    @GetMapping("tovar_by_name")
    public String tovar_by_name(Model model) {
        List<tovar> all = tovarDAO.findAll(Sort.by("name"));
        model.addAttribute("all", all);
        return "tovar";
    }

    @PostMapping("/tovar")
    public String addTovar(tovar tovar, Model model) {
        tovarDAO.save(tovar);
        List<tovar> all = tovarDAO.findAll();
        Collections.reverse(all);
        model.addAttribute("all", all);
        return "tovar";
    }
}
