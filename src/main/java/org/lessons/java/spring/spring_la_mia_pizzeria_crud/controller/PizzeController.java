package org.lessons.java.spring.spring_la_mia_pizzeria_crud.controller;


import java.util.List;

import org.lessons.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



    @Controller
    @RequestMapping("/pizze")
public class PizzeController {

    @Autowired
    private PizzaRepository pizzeRepository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> pizze = pizzeRepository.findAll();
        model.addAttribute("pizze", pizze);
        return "pizze/index";
    }
    



}
