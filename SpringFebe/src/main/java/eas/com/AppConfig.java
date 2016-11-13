package eas.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by eduardo on 11/12/2016.
 */
@Configuration
@PropertySource({"classpath:data.properties", "classpath:data1.properties"})
public class AppConfig {

    @Autowired
    Environment env;


    @Bean
    public FileEncoderInterface fileEncoderISO() {
        FileEncoderInterface encoderInterface = new FileEncoderISO("ISO-8859-1");
        return encoderInterface;
    }

    @Bean
    public FileEncoderInterface fileEncoderUTF() {
        FileEncoderInterface encoderInterface = new FileEncoderUTF("UTF-8");
        return encoderInterface;
    }


    @Bean
    public FileInput file() {
        FileInput fileInput = new FileInput(env.getProperty("file.name"), env.getProperty("file.description"));
        fileInput.setFileEncoderInterface(fileEncoderISO());
        return fileInput;
    }


    @Bean
    public SeparatorContentFile separatorContentFile() {
        SeparatorContentFile separatorContentFile = new SeparatorContentFile();
        separatorContentFile.setValue("#");
        return separatorContentFile;

    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public FileInputStep fileInputStep(){
        FileInputStep fileInputStep = new FileInputStep(file(), separatorContentFile());
        return fileInputStep;
    }
}
