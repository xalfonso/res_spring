package eas.com.service;

import eas.com.AnnotationTest;
import eas.com.InterfaceTest;
import eas.com.util.Data;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/28/2016.
 */
@AnnotationTest
@Service
public class TestService implements InterfaceTest{

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

    public String insertData(Data data){
        LOGGER.log(Level.INFO, "insertData was executed");
        return data.getValue();
    }

    public String listAction(){
        LOGGER.log(Level.INFO, "listAction was executed");
        return "list";
    }

    @AnnotationTest
    public String retrieve(){
        LOGGER.log(Level.INFO, "retrieve was executed");
        return "retrieve";
    }

}
