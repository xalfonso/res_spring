package eas.com.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static eas.com.security.AuthenticationFilterToken.HEADER_NAME_TOKEN;

/**
 * Condition for test if is needed a authentication or not.
 *
 * @author Eduardo Alfonso Sanchez
 * @since 1.0.0
 */
@Component
public class AuthenticateRequiredRequestMatcher implements RequestMatcher {

    /**
     * If is need the authentication or not.
     *
     * @param request The request
     * @return true if is necessary the authentication, false otherwise
     */
    @Override
    public boolean matches(HttpServletRequest request) {
        String token = request.getHeader(HEADER_NAME_TOKEN);
        Authentication oldAuthentication = SecurityContextHolder.getContext().getAuthentication();

        if (oldAuthentication instanceof CustomAuthenticationToken) {
            if (((CustomAuthenticationToken) oldAuthentication).getPrincipal().getToken().equals(token)) {
                System.out.println("Authentication was skipped because the user already is authenticated");
                return false;
            }
        }

        return true;
    }
}
