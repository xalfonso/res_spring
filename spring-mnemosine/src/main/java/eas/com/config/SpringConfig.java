package eas.com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author esanchez
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "eas.com")
public class SpringConfig extends WebMvcConfigurerAdapter {
}
