package eas.com.common.service;

import eas.com.common.dao.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/26/2016.
 */
public class HomeService {

    private final static Logger LOGGER = Logger.getLogger(HomeService.class.getName());

    private HomeDao homeDao;

    @Autowired
    public HomeService(HomeDao homeDao) {
        this.homeDao = homeDao;
    }

    public String home(){
        LOGGER.log(Level.INFO, "Acceding to home method");
        return homeDao.home();
    }
}
