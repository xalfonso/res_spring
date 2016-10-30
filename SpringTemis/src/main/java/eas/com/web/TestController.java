package eas.com.web;

import eas.com.AnnotationTest;
import eas.com.service.TestService;
import eas.com.util.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by eduardo on 10/27/2016.
 */
@Controller
@RequestMapping(value = "/home")
public class TestController {


    @Resource
    private TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public String listAction() {
        this.testService.listAction();
        return testService.list();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertAction() {
        testService.insert("Argument 1", "Argument 2");
        testService.insertData(new Data("Data Test"));
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
        return this.testService.retrieve();
    }


}
