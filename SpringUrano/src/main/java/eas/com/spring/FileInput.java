package eas.com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by eduardo on 10/24/2016.
 */
@Component("file")
public class FileInput {
    @Value("${file.name}")
    private String name;

    @Autowired
    @Qualifier("fileEncoderISO")
    private FileEncoderInterface fileEncoder;

    @Value("${file.description}")
    private String description;

    public FileInput(String name) {
        this.name = name;
    }

    public FileInput() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileEncoderInterface getFileEncoder() {
        return this.fileEncoder;
    }


    public void setFileEncoder(FileEncoderInterface fileEncoder) {
        this.fileEncoder = fileEncoder;
    }
}
