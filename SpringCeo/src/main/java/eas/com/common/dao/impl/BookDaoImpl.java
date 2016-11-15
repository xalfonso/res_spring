package eas.com.common.dao.impl;

import eas.com.common.dao.BookDao;
import eas.com.common.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by eduardo on 11/14/2016.
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Resource
    private SessionFactory sessionFactory;

    public void insert(Book book) throws Exception {
       this.sessionFactory.getCurrentSession().save(book);
    }

    public List<Book> list() throws Exception {
        return this.sessionFactory.getCurrentSession().createQuery("FROM " + Book.class.getName(), Book.class).getResultList();
    }
}
