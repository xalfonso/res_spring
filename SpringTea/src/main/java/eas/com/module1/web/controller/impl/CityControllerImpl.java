package eas.com.module1.web.controller.impl;

import eas.com.module1.facade.Module1Facade;
import eas.com.module1.web.model.ModelData;
import eas.com.module1.web.controller.CityController;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;
import org.springframework.ui.Model;

/**
 * Created by eduardo on 10/26/2016.
 */
@Controller
public class CityControllerImpl implements CityController{

    private final static Logger LOGGER = Logger.getLogger(CityControllerImpl.class.getName());

    private Module1Facade module1Facade;

    @Autowired
    public CityControllerImpl(Module1Facade module1Facade) {
        this.module1Facade = module1Facade;
    }

    @Override
    public String initAction(Model model) {
        LOGGER.log(Level.INFO, "Show cities");        
        model.addAttribute("modelData", new ModelData());
        model.addAttribute("cities", this.module1Facade.cities());
        return "home";
    }    

    public String initAction(Model model, ModelData modelData) {        
        try {
            model.addAttribute("result",this.module1Facade.getDataMeto(modelData));                           
        } catch (Exception ex) {
            model.addAttribute("result","Error: " + ex.getMessage());                           
        }
        
        return "result";
    }
}
