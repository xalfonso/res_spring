package eas.com.common.web.controller.impl;

import eas.com.common.entity.Book;
import eas.com.common.facade.CommonFacade;
import eas.com.common.web.controller.BookController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eduardo on 11/14/2016.
 */
@Controller
public class BookControllerImpl implements BookController {

    @Resource
    private CommonFacade commonFacade;

    private final static Logger LOGGER = Logger.getLogger(BookControllerImpl.class.getName());


    public String listAction(Model model) {

        try {
            List<Book> bookList = this.commonFacade.listBook();
            model.addAttribute("books", bookList);
        } catch (Exception e) {
            LOGGER.error("Error captured", e);
        }

        return "common/listBook";
    }

    public String insertAction(Model model) {
        return null;
    }

    public String insertAction(Model model, Book book) {
        return null;
    }
}
