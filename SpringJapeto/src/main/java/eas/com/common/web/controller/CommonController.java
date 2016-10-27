package eas.com.common.web.controller;

/**
 * Created by eduardo on 10/26/2016.
 */
public interface CommonController {

    default  String getPage(String namePage){
        return "common/" + namePage;
    }
}
