package eas.com.web.managed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EnableSpringHttpSession
@Configuration
public class SpringConfiguration {

    public static Map<String, Session> allSession = new ConcurrentHashMap<>();

    /**
     * Bean for activate the Http Session in Memory.
     *
     * @return Bean of {@link MapSessionRepository}
     * @since 1.0.0
     */
    @Bean
    public MapSessionRepository sessionRepository() {
        return new MapSessionRepository(allSession);
    }
}
