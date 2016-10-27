package eas.com.common.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eduardo on 10/26/2016.
 * This interface represent the contract with the client of all functions under /home
 */
@RequestMapping(value = "home")
public interface HomeController extends CommonController{

    @RequestMapping(method = RequestMethod.GET)
    String initAction();

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String listAction();



}
