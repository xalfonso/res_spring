package eas.com.web.wrapper;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

@Slf4j
public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {
    public CustomHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public HttpSession getSession() {
        HttpSession session = super.getSession();
        if (session != null) {
            log.info("Intercepting CustomHttpServletRequestWrapper.getSession() Session ID: " + session.getId());
            log.info("Intercepting CustomHttpServletRequestWrapper.getSession(). Session IsNew: " + session.isNew());
        }
        return session;
    }

    @Override
    public HttpSession getSession(boolean create) {
        HttpSession session = super.getSession(create);
        if (session != null) {
            log.info("Intercepting CustomHttpServletRequestWrapper.getSession(boolean). Session ID: " + session.getId());
            log.info("Intercepting CustomHttpServletRequestWrapper.getSession(boolean). Session IsNew: " + session.isNew());
        }
        return session;
    }
}
