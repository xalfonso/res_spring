package eas.com.web;

import com.sun.org.apache.xpath.internal.Arg;
import eas.com.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/27/2016.
 */
@Controller
@RequestMapping(value = "/home")
public class TestController {

    private final static Logger LOGGER = Logger.getLogger(TestController.class.getName());

    @Resource
    private TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public String listAction() {
        return testService.list();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertAction() {
        testService.insert("Argument 1", "Argument 2");
        return testService.insert("Argument to Insert");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateAction() {
        return "update";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteAction() {
        return "delete";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String retrieveAction(@PathVariable long id) {
        return "retrieve";
    }


}
