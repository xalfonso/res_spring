package eas.com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by eduardo on 10/25/2016.
 */
public class FileInput {
    @Value("exampleFile.exe")
    private String name;

    @Autowired
    @Qualifier("fileEncoderISO")
    private FileEncoderInterface fileEncoderInterface;

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

    public FileEncoderInterface getFileEncoderInterface() {
        return fileEncoderInterface;
    }

    public void setFileEncoderInterface(FileEncoderInterface fileEncoderInterface) {
        this.fileEncoderInterface = fileEncoderInterface;
    }
}
