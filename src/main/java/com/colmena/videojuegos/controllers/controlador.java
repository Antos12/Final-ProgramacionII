package com.colmena.videojuegos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class controlador {

    @GetMapping(value = "/")
    public String index(Model model){
        String saludo= "Hola Thymeleaf";
        model.addAttribute("saludo", saludo);
        return "index";
    }
}
