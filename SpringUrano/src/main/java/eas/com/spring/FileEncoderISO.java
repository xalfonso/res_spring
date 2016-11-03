package eas.com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by eduardo on 10/24/2016.
 */
@Component
public class FileEncoderISO implements FileEncoderInterface {

    @Value("ISO-8859-1")
    private String name;


    public String getName() {
        return name;
    }
}
