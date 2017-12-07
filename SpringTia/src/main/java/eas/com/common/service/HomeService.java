package eas.com.common.service;

import eas.com.common.dao.HomeDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
        LOGGER.debug("Acceding to home method in the service");
        return homeDao.home();
    }
}
