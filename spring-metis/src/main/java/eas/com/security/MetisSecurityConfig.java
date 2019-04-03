package eas.com.security;

import ec.com.kruger.security.config.RestSecurityConfig;
import ec.com.kruger.security.extension.IHttpSecurityConfigurer;
import ec.com.kruger.security.provider.InMemoryAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Import(RestSecurityConfig.class)
@Configuration
public class MetisSecurityConfig {

    /**
     * Bean of {@link IHttpSecurityConfigurer} for custom configuration of {@link HttpSecurity}.
     *
     * @return The bean of {@link IHttpSecurityConfigurer} for custom configuration of {@link HttpSecurity}
     * @since 1.0.0
     */
    @Bean
    public IHttpSecurityConfigurer<HttpSecurity> httpSecurityConfigurer() {
        return httpSecurity -> httpSecurity
                .authorizeRequests()
                .antMatchers("/student/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    /**
     * Provider in Memory for testing. Wen can use other for real provider.
     *
     * @return InMemoryAuthenticationProvider
     * @since 1.0.0
     */
    @Bean
    public InMemoryAuthenticationProvider memoryAuthenticationProvider() {
        return configurer -> configurer
                .withUser("develop01").password("{noop}Password01").roles("USER")
                .and()
                .withUser("develop02").password("{noop}Password02").roles("ADMIN");
    }
}
