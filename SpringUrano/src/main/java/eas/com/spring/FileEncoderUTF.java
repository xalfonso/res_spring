package eas.com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by eduardo on 10/24/2016.
 */
@Component
public class FileEncoderUTF implements FileEncoderInterface {
    @Value("UTF-8")
    private String name;

    public FileEncoderUTF() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
