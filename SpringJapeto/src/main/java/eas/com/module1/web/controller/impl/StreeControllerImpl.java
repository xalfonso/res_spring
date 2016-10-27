package eas.com.module1.web.controller.impl;

import eas.com.module1.service.StreeService;
import eas.com.module1.web.controller.StreeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

/**
 * Created by eduardo on 10/26/2016.
 */
@Controller
public class StreeControllerImpl implements StreeController{

    private final static Logger LOGGER = Logger.getLogger(StreeControllerImpl.class.getName());

    private StreeService streeService;

    @Autowired
    public StreeControllerImpl(StreeService streeService) {
        this.streeService = streeService;
    }

    public String initAction() {
        return getPage(this.streeService.stree());
    }

    public String listAction() {
        return getPage("list");
    }
}
