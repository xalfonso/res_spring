package eas.com.module1.web.controller;

import eas.com.module1.web.model.ModelData;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eduardo on 10/26/2016.
 */
@RequestMapping(value = "/cities")
public interface CityController {

    @RequestMapping(method = RequestMethod.GET)
    String initAction(Model model);
    
    @RequestMapping(method = RequestMethod.POST)
    String initAction(Model model, ModelData modelData);
    
}
