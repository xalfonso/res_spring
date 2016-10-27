package eas.com.common.web.controller.impl;


import eas.com.common.service.HomeService;
import eas.com.common.web.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/26/2016.
 */
@Controller
public class HomeControllerImpl implements HomeController {

    private final static Logger LOGGER = Logger.getLogger(HomeControllerImpl.class.getName());

    private HomeService homeService;


    @Autowired
    public HomeControllerImpl(HomeService homeService) {
        this.homeService = homeService;
    }

    public String initAction() {
        LOGGER.log(Level.INFO, "Acceding to initAction method");
        return getPage(this.homeService.home());
    }

    public String listAction() {
        LOGGER.log(Level.INFO, "Acceding to list method");
        return getPage("list");
    }
}
