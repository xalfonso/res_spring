package eas.com.common.web.controller.impl;


import eas.com.common.entity.Student;
import eas.com.common.facade.CommonFacade;
import eas.com.common.service.HomeService;
import eas.com.common.web.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/26/2016.
 */
@Controller
public class HomeControllerImpl implements HomeController {

    private final static Logger LOGGER = Logger.getLogger(HomeControllerImpl.class.getName());

    private CommonFacade commonFacade;

    @Value("#{countries}")
    private Map<String, String> countries;


    @Autowired
    public HomeControllerImpl(CommonFacade commonFacade) {
        this.commonFacade = commonFacade;
    }

    public String initAction(Model model) {
        LOGGER.log(Level.INFO, "Acceding to initAction method");
        model.addAttribute("student", new Student());
        model.addAttribute("countries", this.countries);
        return getPage(this.commonFacade.home());
    }

    public String listAction() {
        LOGGER.log(Level.INFO, "Acceding to list method");
        return getPage("list");
    }
}
