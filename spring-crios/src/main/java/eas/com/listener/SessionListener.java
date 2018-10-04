package eas.com.listener;

import lombok.extern.apachecommons.CommonsLog;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@CommonsLog
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        log.info("==== Session is created ====");
        event.getSession().setMaxInactiveInterval(60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        log.info("==== Session is destroyed ====");
    }
}