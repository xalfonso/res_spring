package eas.com;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eduardo on 11/12/2016.
 */
public class FileInputStep {

    private String name;
    private FileInput fileInput;
    private SeparatorContentFile separatorContentFile;

    public FileInputStep(FileInput fileInput, SeparatorContentFile separatorContentFile) {
        this.name = "EmptyFileInputStep";
        this.fileInput = fileInput;
        this.separatorContentFile = separatorContentFile;
    }


    public void init(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("Init method FileInputStep" + ". Time: "+ sdf.format(new Date()));
    }


    public void destroy(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("Destroy method FileInputStep" + ". Time: "+ sdf.format(new Date()));
    }

    public FileInput getFileInput() {
        return fileInput;
    }

    public void setFileInput(FileInput fileInput) {
        this.fileInput = fileInput;
    }

    public SeparatorContentFile getSeparatorContentFile() {
        return separatorContentFile;
    }

    public void setSeparatorContentFile(SeparatorContentFile separatorContentFile) {
        this.separatorContentFile = separatorContentFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
