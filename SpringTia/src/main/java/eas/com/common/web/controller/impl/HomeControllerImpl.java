package eas.com.common.web.controller.impl;


import eas.com.common.entity.Student;
import eas.com.common.facade.CommonFacade;
import eas.com.common.service.TaskService;
import eas.com.common.web.controller.HomeController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by eduardo on 10/26/2016.
 */
@Controller
public class HomeControllerImpl implements HomeController {

    private final static Logger LOGGER = org.apache.log4j.Logger.getLogger(HomeControllerImpl.class.getName());

    private CommonFacade commonFacade;

    @Value("#{countries}")
    private Map<String, String> countries;

    @Resource
    private TaskService taskService;


    @PostConstruct
    public void postConstructor() throws ExecutionException, InterruptedException {
        LOGGER.debug("Call postConstructor. "
                + Thread.currentThread().getName());
        Future<String> future = taskService.taskAsync1();

        while (true) {
            if (future.isDone()) {
                LOGGER.debug("Result from taskService.taskAsync1() - " + future.get());
                break;
            }
            LOGGER.debug("Continue doing something else. ");
            Thread.sleep(1000);
        }
    }

    @Autowired
    public HomeControllerImpl(CommonFacade commonFacade) {
        this.commonFacade = commonFacade;
    }

    public String initAction(Model model) {
        LOGGER.debug("Acceding to initAction method");
        model.addAttribute("student", new Student());
        model.addAttribute("countries", this.countries);
        return getPage(this.commonFacade.home());
    }

    public String listAction() {
        LOGGER.debug("Acceding to list method");
        return getPage("list");
    }
}
