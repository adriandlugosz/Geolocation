package pl.adriandlugosz.geolocalizer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.adriandlugosz.geolocalizer.repository.GeoCoordinate;

@Controller
public class GeoController {

    @Autowired
    private GeoCoordinate geoCoordinate;

    @GetMapping("/view/form")
    public String add() {
        return "add";
    }

    @PostMapping("/view")
    public String data(@RequestParam String formResponse) {
        geoCoordinate.setAdress(formResponse);
        return "redirect:/view";
    }

    @GetMapping("/view")
    public String coordinates(ModelMap modelMap) {
        modelMap.addAttribute("coordinates", geoCoordinate.getCoordinate());
        modelMap.addAttribute("address", geoCoordinate.getAdress());
        return "view";
    }

}
