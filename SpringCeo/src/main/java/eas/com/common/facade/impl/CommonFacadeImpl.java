package eas.com.common.facade.impl;

import eas.com.common.entity.Book;
import eas.com.common.facade.CommonFacade;
import eas.com.common.service.BookService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eduardo on 11/14/2016.
 */
@Component
public class CommonFacadeImpl  implements CommonFacade{

    @Resource
    private BookService bookService;

    public void insertBook(Book book) throws Exception{
       this.bookService.insert(book);
    }

    public List<Book> listBook() throws Exception{
        return this.bookService.list();
    }
}
