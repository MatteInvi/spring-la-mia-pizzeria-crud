package org.lessons.java.spring.spring_la_mia_pizzeria_crud.controller;


import java.util.List;

import org.lessons.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



    @Controller
    @RequestMapping("/pizze")
public class PizzeController {

    @Autowired
    private PizzaRepository pizzeRepository;

    @GetMapping
    public String index(Model model, @RequestParam(required = false) String keyword) {
        List<Pizza> pizze;
    if (keyword!=null && !keyword.isEmpty()){
          pizze= pizzeRepository.findByNomeContainingIgnoreCase(keyword);
    } else {
        pizze = pizzeRepository.findAll();
    }  

        model.addAttribute("pizze", pizze);
        return "pizze/index";
    }

    @GetMapping("/{id}")
    public String show( @PathVariable Integer id, Model model){
        model.addAttribute("pizze", pizzeRepository.findById(id).get());
        return "pizze/show";

    }



}
