package eas.com.module1.web.controller.impl;

import eas.com.module1.facade.Module1Facade;
import eas.com.module1.web.controller.StreeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

/**
 * Created by eduardo on 10/26/2016.
 */
@Controller
public class StreeControllerImpl implements StreeController{

    private final static Logger LOGGER = Logger.getLogger(StreeControllerImpl.class.getName());

    private Module1Facade module1Facade;

    @Autowired
    public StreeControllerImpl(Module1Facade module1Facade) {
        this.module1Facade = module1Facade;
    }

    public String initAction() {
        return getPage(this.module1Facade.stree());
    }

    public String listAction() {
        return getPage("list");
    }
}
