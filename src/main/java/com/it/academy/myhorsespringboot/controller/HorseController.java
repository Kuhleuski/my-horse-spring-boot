package com.it.academy.myhorsespringboot.controller;

import com.it.academy.myhorsespringboot.service.HorseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HorseController {
    private final HorseService horseService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Главная страница");
        return "index";
    }

    @GetMapping("/all-horses")
    public String horseMain(Model model) {
        model.addAttribute("horses", horseService.findAllHorses());
        return "all-horses";
    }
    
    @GetMapping("/add-new-horse")
    public String addHorse() {
        return "add-new-horse";
    }

    @PostMapping("/add-new-horse")
    public String addHorsePost(@RequestParam String type, @RequestParam int age, @RequestParam double price) {
        horseService.createHorse(type, age, price);
        return "redirect:/all-horses";
    }

    @PostMapping("/delete-horse={id}")
    public String deleteHorsePost(@PathVariable(value = "id") int id) {
        horseService.deleteHorse(id);
        return "redirect:/all-horses";
    }

    @GetMapping("/update-horse={id}")
    public String horseUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("horse", horseService.findHorseById(id));
        return "update-horse";
    }

    @PostMapping("/update-horse={id}")
    public String horsePostUpdate(@PathVariable(value = "id") int id, @RequestParam String type, @RequestParam int age, @RequestParam double price) {
        horseService.updateHorse(id, type, age, price);
        return "redirect:/all-horses";
    }
}
