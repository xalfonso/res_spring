package eas.com.web.managed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersephoneSpringConfiguration {

    @Bean
    public CustomFilterSession customFilterSession() {
        return new CustomFilterSession();
    }
}
