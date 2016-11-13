package eas.com;

/**
 * Created by eduardo on 11/12/2016.
 */
public class FileEncoderISO implements FileEncoderInterface {

    private String name;

    public FileEncoderISO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
