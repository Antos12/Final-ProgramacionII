package com.colmena.videojuegos.controllers;

import com.colmena.videojuegos.entidades.Videojuego;
import com.colmena.videojuegos.services.ServicioVideojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping ("/detalle/{id}")
    public String detalleVideojuego (Model model, @PathVariable("id")Long id){
        try
        {
            Videojuego videojuego = this.svcVideojuego.findByIdAndActivo(id);
            model.addAttribute("videojuego", videojuego);
            return "view/detalle";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping(value = "/busqueda")
    public String busquedaVideojuego (Model model, @RequestParam(value = "query",required = false)String q){
        try{
            List<Videojuego> videojuegos=this.svcVideojuego.findByTitle(q);
            model.addAttribute("videojuegos", videojuegos);
            return "view/busqueda";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
