package eas.com.controller.impl;

import eas.com.controller.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeControllerImpl implements HomeController {

    @Override
    public String homeAction(Model model) {
        model.addAttribute("name", "Probando Spring MVC");
        return "home";
    }
}
