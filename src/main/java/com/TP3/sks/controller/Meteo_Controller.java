package com.TP3.sks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Meteo_Controller {
    @GetMapping("/adresse")
    public String meteo(Model model){
        return "adresse";
    }
}
