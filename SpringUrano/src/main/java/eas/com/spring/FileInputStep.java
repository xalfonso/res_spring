package eas.com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eduardo on 10/24/2016.
 */
@Component
public class FileInputStep extends ComponentStep {

    protected FileInput fileInput;
    protected SeparatorContentFile separatorContentFile;

    public FileInputStep(String name, FileInput fileInput, SeparatorContentFile separatorContentFile) {
        super(name);
        this.fileInput = fileInput;
        this.separatorContentFile = separatorContentFile;
    }

    @Autowired
    public FileInputStep(FileInput fileInput, SeparatorContentFile separatorContentFile) {
        super("EmptyFileInputStep");
        this.fileInput = fileInput;
        this.separatorContentFile = separatorContentFile;
    }

    public FileInputStep() {
        super("EmptyFileInputStep");
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
}
