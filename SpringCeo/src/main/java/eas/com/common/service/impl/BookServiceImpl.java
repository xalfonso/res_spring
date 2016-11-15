package eas.com.common.service.impl;

import eas.com.common.dao.BookDao;
import eas.com.common.entity.Book;
import eas.com.common.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eduardo on 11/14/2016.
 */
@Transactional(readOnly = true)
@Service
public class BookServiceImpl implements BookService{

    @Resource
    private BookDao bookDao;

    @Transactional
    public void insert(Book book) throws Exception {
      this.bookDao.insert(book);
    }

    public List<Book> list() throws Exception {
        return this.bookDao.list();
    }
}
