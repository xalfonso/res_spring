package eas.com.spring;

/**
 * Created by eduardo on 10/22/2016. eddie.alfonso@gmail.com
 */
public class FileInput {
    private String name;
    private FileEncoder fileEncoder;
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
