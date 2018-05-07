package eas.com.controller.impl;

import eas.com.controller.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Collections;

@Controller
public class HomeControllerImpl implements HomeController {

    @Override
    public String homeAction(Model model) {
        model.addAttribute("name", "probando");
        return "home";
    }
}
