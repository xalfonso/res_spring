package eas.com;

/**
 * Created by eduardo on 11/12/2016.
 */
public class FileEncoderUTF implements FileEncoderInterface {

    private String name;

    public FileEncoderUTF(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
