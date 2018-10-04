package eas.com.config;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Objects;

/**
 * Authentication Provider.
 *
 * @author Eduardo Alfonso Sanchez
 * @since 1.0.0
 */
@CommonsLog
@Component
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    @Resource
    private HttpServletRequest httpServletRequest;

    private final String securityContextVar = "SPRING_SECURITY_CONTEXT";

    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public Authentication authenticate(Authentication authentication) {
        Authentication authenticationOld = SecurityContextHolder.getContext().getAuthentication();

        User user;
        if (authenticationOld == null || authenticationOld.getPrincipal() == null || !Objects.equals(authenticationOld.getName(), authentication.getName())) {
            if (log.isInfoEnabled()) {
                log.info("Se procedera a realizar la autenticacion del usuario: " + authentication.getName());
            }
            user = getUserFromDb(authentication.getName());
        } else {
            if (log.isInfoEnabled()) {
                log.info("Se evitara realizar la autenticacion del usuario: " + authentication.getName());
            }
            user = (User) authenticationOld.getPrincipal();
        }

        return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
    }


    /**
     * {@inheritDoc}
     *
     * @since 1.0.0
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    private User getUserFromDb(String username) {
        return new User(username, "", Collections.emptyList());
    }

}
