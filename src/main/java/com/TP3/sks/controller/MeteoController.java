package com.TP3.sks.controller;

import com.TP3.sks.SksApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;


@Controller
public class MeteoController {
    @Autowired
    RestTemplate restTemplate;

    List<String> states = Arrays.asList(
            "Soleil",
            "Peu nuageux",
            "Ciel voilé",
            "Nuageux",
            "Très nuageux",
            "Couvert",
            "Brouillard",
            "Brouillard givrant",
            "Pluie faible",
            "Pluie modérée",
            "Pluie forte",
            "Pluie faible verglaçante",
            "Pluie modérée verglaçante",
            "Pluie forte verglaçante",
            "Bruine",
            "Neige faible",
            "Neige modérée",
            "Neige forte",
            "Pluie et neige mêlées faibles",
            "Pluie et neige mêlées modérées",
            "Pluie et neige mêlées fortes",
            "Averses de pluie locales et faibles",
            "Averses de pluie locales",
            "Averses locales et fortes",
            "Averses de pluie faibles",
            "Averses de pluie",
            "Averses de pluie fortes",
            "Averses de pluie faibles et fréquentes",
            "Averses de pluie fréquentes",
            "Averses de pluie fortes et fréquentes",
            "Averses de neige localisées et faibles",
            "Averses de neige localisées",
            "Averses de neige localisées et fortes",
            "Averses de neige faibles",
            "Averses de neige",
            "Averses de neige fortes",
            "Averses de neige faibles et fréquentes",
            "Averses de neige fréquentes",
            "Averses de neige fortes et fréquentes",
            "Averses de pluie et neige mêlées localisées et faibles",
            "Averses de pluie et neige mêlées localisées",
            "Averses de pluie et neige mêlées localisées et fortes",
            "Averses de pluie et neige mêlées faibles",
            "Averses de pluie et neige mêlées",
            "Averses de pluie et neige mêlées fortes",
            "Averses de pluie et neige mêlées faibles et nombreuses",
            "Averses de pluie et neige mêlées fréquentes",
            "Averses de pluie et neige mêlées fortes et fréquentes",
            "Orages faibles et locaux",
            "Orages locaux",
            "Orages fort et locaux",
            "Orages faibles",
            "Orages",
            "Orages forts",
            "Orages forts et fréquents",
            "Orages faibles et locaux de neige ou grésil",
            "Orages locaux de neige ou grésil",
            "Orages locaux de neige ou grésil",
            "Orages faibles de neige ou grésil",
            "Orages de neige ou grésil",
            "Orages de neige ou grésil",
            "Orages faibles et fréquents de neige ou grésil",
            "Orages fréquents de neige ou grésil",
            "Orages fréquents de neige ou grésil",
            "Orages faibles et locaux de pluie et neige mêlées ou grésil",
            "Orages locaux de pluie et neige mêlées ou grésil",
            "Orages fort et locaux de pluie et neige mêlées ou grésil",
            "Orages faibles de pluie et neige mêlées ou grésil",
            "Orages de pluie et neige mêlées ou grésil",
            "Orages forts de pluie et neige mêlées ou grésil",
            "Orages faibles et fréquents de pluie et neige mêlées ou grésil",
            "Orages fréquents de pluie et neige mêlées ou grésil",
            "Orages forts et fréquents de pluie et neige mêlées ou grésil",
            "Pluies orageuses",
            "Pluie et neige mêlées à caractère orageux",
            "Neige à caractère orageux",
            "Pluie faible intermittente",
            "Pluie modérée intermittente",
            "Pluie forte intermittente",
            "Neige faible intermittente",
            "Neige modérée intermittente",
            "Neige forte intermittente",
            "Pluie et neige mêlées",
            "Pluie et neige mêlées",
            "Pluie et neige mêlées",
            "Averses de grêle");
    @GetMapping("/meteo")
    public String meteo(Model model){
        return "meteo";
    }
    @PostMapping("/meteo")
    public String meteo_(@RequestParam("address") String adress,Model model) {
        System.out.println(adress);

        String quote = restTemplate.getForObject("https://api-adresse.data.gouv.fr/search/?q=" + adress, String.class);
        System.out.println(quote);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(quote);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        JsonNode firstFeature = rootNode.path("features").get(0);
        double x = firstFeature.path("geometry").path("coordinates").get(1).asDouble();
        double y = firstFeature.path("geometry").path("coordinates").get(0).asDouble();
        String city = firstFeature.path("properties").path("city").toString();
        System.out.println("x: " + x + ", y: " + y);

        String meteo_status = restTemplate.getForObject("https://api.meteo-concept.com/api/forecast/nextHours?token=4eb60666098b31821730c9a74f64877ae231d95249b2a932262cac27a24d30c2&latlng=" + x + "," + y, String.class);
        System.out.println(meteo_status);
        JsonNode meteo_Node = null;
        try {
            rootNode = objectMapper.readTree(meteo_status);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        JsonNode firstFeature_meteo = rootNode.path("forecast").get(0);
        int temp = firstFeature_meteo.path("temp2m").asInt();
        int wheter_ref = firstFeature_meteo.path("weather").asInt();
        String wheter = states.get(wheter_ref);
        model.addAttribute("temp",temp);
        model.addAttribute("wheter",wheter);
        model.addAttribute("city",city);
        return "meteo";
    }
}


