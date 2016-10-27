package eas.com.module1.web.controller;

/**
 * Created by eduardo on 10/27/2016.
 */
public interface Module1Controller {

    default  String getPage(String namePage){
        return "module1/" + namePage;
    }
}
