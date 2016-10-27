package eas.com.common.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/26/2016.
 */
public class HomeDao {

    private final static Logger LOGGER = Logger.getLogger(HomeDao.class.getName());

    public String home(){
        LOGGER.log(Level.INFO, "Acceding to home method");
        return "home";
    }
}
