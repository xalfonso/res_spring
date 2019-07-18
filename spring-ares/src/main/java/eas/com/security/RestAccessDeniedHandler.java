package eas.com.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handler called when the user do not have access to specific resource by permission.
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * {@inheritDoc}
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}
