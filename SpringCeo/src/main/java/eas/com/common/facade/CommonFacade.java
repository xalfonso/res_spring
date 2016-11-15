package eas.com.common.facade;

import eas.com.common.entity.Book;

import java.util.List;

/**
 * Created by eduardo on 11/14/2016.
 */
public interface CommonFacade {

    void insertBook(Book book) throws Exception;

    List<Book> listBook() throws Exception;
}
