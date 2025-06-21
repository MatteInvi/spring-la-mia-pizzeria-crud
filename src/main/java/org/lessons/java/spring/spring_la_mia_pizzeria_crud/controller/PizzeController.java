package org.lessons.java.spring.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.lessons.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.java.spring.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/pizze")
public class PizzeController {

    @Autowired
    private PizzaRepository pizzeRepository;

    @GetMapping
    public String index(Model model, @RequestParam(required = false) String keyword) {
        List<Pizza> pizze;
        if (keyword != null && !keyword.isEmpty()) {
            pizze = pizzeRepository.findByNomeContainingIgnoreCase(keyword);
        } else {
            pizze = pizzeRepository.findAll();
        }

        model.addAttribute("pizze", pizze);
        return "pizze/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("pizza", pizzeRepository.findById(id).get());
        return "pizze/show";

    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "pizze/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/pizze/create";
        }

        pizzeRepository.save(formPizza);
        return "redirect:/pizze";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("pizza", pizzeRepository.findById(id).get());
        return"pizze/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("pizza") Pizza formPizza,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "/pizze/edit";
        }

        pizzeRepository.save(formPizza);

        return "redirect:/pizze";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){
        pizzeRepository.deleteById(id);
        return "redirect:/pizze";
    }

}
