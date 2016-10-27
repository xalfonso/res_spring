package eas.com.module1.service;

import eas.com.module1.dao.StreeDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by eduardo on 10/26/2016.
 */
public class StreeService {

    private StreeDao streeDao;

    @Autowired
    public StreeService(StreeDao streeDao) {
        this.streeDao = streeDao;
    }

    public String stree(){
       return this.streeDao.stree();
    }
}
