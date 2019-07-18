package eas.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * Authentication Provider by Token Against the corp system.
 */
@Component
public class RestAuthenticationProvider implements AuthenticationProvider {

    private static List<GrantedAuthority> defaultAuthorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

    @Autowired
    private HttpServletRequest httpServletRequest;


    /**
     * {@inheritDoc}
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        httpServletRequest.getContextPath();
        httpServletRequest.getHeaderNames();

        System.out.println("username: " + authentication.getName());
        System.out.println("password: " + authentication.getCredentials().toString());

        User user = null;

        String token = authentication.getName();
        if (token != null && !token.isEmpty()) {
            user = loadUser(authentication.getName(), authentication.getCredentials().toString());
            if (user == null) {
                throw new BadCredentialsException("The token is invalid");
            }
        } else {
            throw new BadCredentialsException("The token is invalid");
        }

        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    /**
     * The user information from corp.
     *
     * @return The {@link User}
     */
    private User loadUser(String username, String password) {
        User user = new User("ealfonso", "ealfonso01", defaultAuthorities);
        if (user.getUsername().equals(username) && user.getPassword().equals(password))
            return user;
        return null;
    }
}
