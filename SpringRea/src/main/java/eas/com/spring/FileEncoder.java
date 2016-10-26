package eas.com.spring;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by eduardo on 10/25/2016.
 */
public class FileEncoder implements FileEncoderInterface {
    @Value("UTF-8")
    private String name;

    public FileEncoder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
