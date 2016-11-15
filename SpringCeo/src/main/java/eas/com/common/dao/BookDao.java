package eas.com.common.dao;

import eas.com.common.entity.Book;

import java.util.List;

/**
 * Created by eduardo on 11/14/2016.
 */
public interface BookDao {

    void insert(Book book) throws Exception;

    List<Book> list()throws Exception;
}
