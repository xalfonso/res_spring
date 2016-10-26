package eas.com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by eduardo on 10/25/2016.
 */
@Configuration
@ComponentScan("eas.com.spring")
@PropertySource("classpath:data.properties")
public class AppConfig {


    /**
     * In this case the dependency of this bean is inject with the annotation @Value
     * @return
     */
    @Bean
    public FileEncoderInterface fileEncoderISO() {
        FileEncoderInterface encoderInterface = new FileEncoderISO();
        return encoderInterface;
    }

    /**
     * In this case the dependency of this bean is inject with the annotation @Value and @Autowired
     * @see FileInput inside
     * @return
     */
    @Bean
    public FileInput file() {
        FileInput fileInput = new FileInput();
        return fileInput;
    }

    /**
     * In this case I inject directly the dependency, but work fine with the annotation in the setter method
     * @return
     */
    @Bean
    public SeparatorContentFile separatorContentFile() {
        SeparatorContentFile separatorContentFile = new SeparatorContentFile();
        separatorContentFile.setValue("#");
        return separatorContentFile;

    }

    /**
     * In this case, i want to use the constructor for inject the dependency, for that i need inject myself the dependency: file() and separatorContentFile()
     * @return
     */
    @Bean
    public FileInputStep fileInputStep(){
        FileInputStep fileInputStep = new FileInputStep(file(), separatorContentFile());
        return fileInputStep;
    }
}
