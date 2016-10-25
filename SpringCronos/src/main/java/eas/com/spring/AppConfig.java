package eas.com.spring;

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
}
