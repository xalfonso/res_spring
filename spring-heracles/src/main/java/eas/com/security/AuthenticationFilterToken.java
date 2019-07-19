package eas.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilterToken extends UsernamePasswordAuthenticationFilter {

    public static final String HEADER_NAME_TOKEN = "Authorization";

    @Autowired
    private AuthenticateRequiredRequestMatcher authenticateRequiredRequestMatcher;

    @PostConstruct
    public void init() {
        this.setRequiresAuthenticationRequestMatcher(authenticateRequiredRequestMatcher);
        this.setContinueChainBeforeSuccessfulAuthentication(true);
    }

    @Autowired
    @Override
    public void setAuthenticationManager(@Qualifier("restAuthenticationManager") AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Autowired
    @Override
    public void setAuthenticationFailureHandler(@Qualifier("restAuthenticationFailureHandler") AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String token = request.getHeader(HEADER_NAME_TOKEN);
        CustomPrincipalToken earlyCustomPrincipalToken = new CustomPrincipalToken(token);
        CustomAuthenticationToken earlyCustomAuthenticationToken = new CustomAuthenticationToken(earlyCustomPrincipalToken);

        return authenticate(earlyCustomAuthenticationToken);
    }

    private Authentication authenticate(CustomAuthenticationToken earlyCustomAuthenticationToken) {
        Authentication newAuthentication = getAuthenticationManager().authenticate(earlyCustomAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);
        return newAuthentication;
    }
}
