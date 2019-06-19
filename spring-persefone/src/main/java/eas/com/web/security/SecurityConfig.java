package eas.com.web.security;

import ec.com.kruger.security.sso.springsecurity.config.WebSecurityKeyCloakConfig;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springsecurity.AdapterDeploymentContextFactoryBean;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
import org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Slf4j
@Import(WebSecurityKeyCloakConfig.class)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Autowired
    private KeycloakPreAuthActionsFilter keycloakPreAuthActionsFilter;

    @Autowired
    private LogoutFilter logoutFilter;

    @Autowired
    private KeycloakAuthenticationProcessingFilter keycloakAuthenticationProcessingFilter;

    @Autowired
    private KeycloakAuthenticationProvider keycloakAuthenticationProvider;


    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return (authentication, httpServletRequest, httpServletResponse) -> {
            System.out.println("Add Session Strategy: " + authentication);
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterBefore(keycloakPreAuthActionsFilter, LogoutFilter.class)
                .addFilterAt(logoutFilter, logoutFilter.getClass())
                .addFilterBefore(keycloakAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/index.xhtml").permitAll()
                .antMatchers("/other.xhtml").hasRole("OFFLINE_ACCESS")
                .antMatchers("/other1.xhtml").hasRole("OFFLINE_ACCESS1")
                .anyRequest().authenticated();
    }

    /*@Bean
    public AdapterDeploymentContextFactoryBean adapterDeploymentContext() {
        ClassPathResource resource = new ClassPathResource("keycloak.json");
        return new AdapterDeploymentContextFactoryBean(resource);
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
