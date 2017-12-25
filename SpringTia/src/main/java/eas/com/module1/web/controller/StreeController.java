Ipackage eas.com.module1.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eduardo on 10/26/2016.
 Modificad
 */
@RequestMapping(value = "stree")
public interface StreeController extends Module1Controller{

    @RequestMapping(method = RequestMethod.GET)
    String initAction();

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String listAction();
}