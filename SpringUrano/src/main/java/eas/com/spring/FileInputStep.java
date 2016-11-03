package eas.com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eduardo on 10/24/2016.
 */
@Component
public class FileInputStep {

    private String name;
    private FileInput fileInput;
    private SeparatorContentFile separatorContentFile;

    @Autowired
    public FileInputStep(@Qualifier("file") FileInput fileInput, SeparatorContentFile separatorContentFile) {
        this.name = "EmptyFileInputStep";
        this.fileInput = fileInput;
        this.separatorContentFile = separatorContentFile;
    }

    @PostConstruct
    public void init() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("Init method FileInputStep" + ". Time: " + sdf.format(new Date()));
    }

    @PreDestroy
    public void destroy() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("Destroy method FileInputStep" + ". Time: " + sdf.format(new Date()));
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
