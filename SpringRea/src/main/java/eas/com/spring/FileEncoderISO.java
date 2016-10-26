package eas.com.spring;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by eduardo on 10/25/2016.
 */
public class FileEncoderISO implements FileEncoderInterface {

    @Value("ISO-I19875")
    private String name;


    public String getName() {
        return name;
    }
}
