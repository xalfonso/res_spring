package eas.com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by eduardo on 10/24/2016.
 */
@Component
public class FileInput {
    @Value("exampleFile.exe")
    private String name;
    private FileEncoder fileEncoder;

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

    public FileEncoder getFileEncoder() {
        return fileEncoder;
    }

    public void setFileEncoder(FileEncoder fileEncoder) {
        this.fileEncoder = fileEncoder;
    }
}
