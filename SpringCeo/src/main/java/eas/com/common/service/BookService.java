package eas.com.common.service;

import eas.com.common.entity.Book;

import java.util.List;

/**
 * Created by eduardo on 11/14/2016.
 */
public interface BookService {

    void insert(Book book) throws Exception;

    List<Book> list() throws Exception;
}
