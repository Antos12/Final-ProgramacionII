package com.colmena.videojuegos.controllers;

import com.colmena.videojuegos.entidades.Videojuego;
import com.colmena.videojuegos.services.ServicioVideojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class controladorVideojuego {
    @Autowired
    private ServicioVideojuego svcVideojuego;

    @GetMapping("inicio")
    public String inicio(Model model){
        try{
            List<Videojuego> videojuegos=this.svcVideojuego.findAllByActivo();
            model.addAttribute("videojuegos", videojuegos);

            return "view/inicio";
        }catch (Exception e){
            return "";
        }
    }
}
