package eas.com.common.web.controller;

import eas.com.common.entity.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eduardo on 11/14/2016.
 */
@RequestMapping(value = "/book")
public interface BookController {

    @RequestMapping(method = RequestMethod.GET)
    String listAction(Model model);

    /**
     * For show the form for insert a book
     * @param model model of spring
     * @return page to go
     */
    @RequestMapping(value = "/insert",  method = RequestMethod.GET)
    String insertAction(Model model);

    /**
     * For insert the book
     * @param model model of spring
     * @param book book to insert
     * @return page to go
     */
    @RequestMapping(value = "/insert",  method = RequestMethod.POST)
    String insertAction(Model model, Book book);



}
