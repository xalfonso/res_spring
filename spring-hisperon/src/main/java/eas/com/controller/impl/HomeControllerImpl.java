package eas.com.controller.impl;

import eas.com.controller.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeControllerImpl implements HomeController {

    @Override
    public String homeAction(Model model) {
        model.addAttribute("name", "Probando llamada a metodo Ajax desde JQuery");
        return "home";
    }

    @Override
    public String goExternalSystemAction(Model model) {
        return "gatewayToExternalSystem";
    }
}
