package eas.com;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eduardo on 11/12/2016.
 */
public class FileInput {

    private String name;

    private FileEncoderInterface fileEncoderInterface;

    private String description;

    public FileInput(String name, String description) {
        this.name = name;
        this.description = description;
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

    /**
     * By default the destroyMethod can have the name shutdown or close
     */
    public void shutdown(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("Destroy method FileInput" + ". Time: "+ sdf.format(new Date()));
    }
}
