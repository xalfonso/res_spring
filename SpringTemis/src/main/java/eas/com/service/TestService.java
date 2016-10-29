package eas.com.service;

import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/28/2016.
 */
@Service
public class TestService {

    private final static Logger LOGGER = Logger.getLogger(TestService.class.getName());

    public String list(){
        LOGGER.log(Level.INFO, "list was executed");
        return "list";
    }

    public String insert(String value){
        LOGGER.log(Level.INFO, "insert1 was executed");
        return "insert";
    }

    public String insert(String value, String value1){
        LOGGER.log(Level.INFO, "insert2 was executed");
        return "insert";
    }


}
