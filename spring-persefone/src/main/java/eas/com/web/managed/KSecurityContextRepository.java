package eas.com.web.managed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class KSecurityContextRepository implements SecurityContextRepository {

    public Map<String, SecurityContext> securityContextMap = new ConcurrentHashMap<>();


    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder httpRequestResponseHolder) {
        log.info("Call KSecurityContextRepository.loadContext");
        log.info("Session ID: " + httpRequestResponseHolder.getRequest().getSession().getId());

        SecurityContext securityContext;
        if (securityContextMap.containsKey(httpRequestResponseHolder.getRequest().getSession().getId())) {
            securityContext = securityContextMap.get(httpRequestResponseHolder.getRequest().getSession().getId());
        } else {
            securityContext = SecurityContextHolder.createEmptyContext();
        }
        return securityContext;
    }

    @Override
    public void saveContext(SecurityContext securityContext, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.info("Call KSecurityContextRepository.saveContext");
        log.info("Session ID: " + httpServletRequest.getSession().getId());
        securityContextMap.put(httpServletRequest.getSession().getId(), securityContext);
    }

    @Override
    public boolean containsContext(HttpServletRequest httpServletRequest) {
        log.info("Call KSecurityContextRepository.containsContext");
        log.info("Session ID: " + httpServletRequest.getSession().getId());
        return securityContextMap.containsKey(httpServletRequest.getSession().getId());
    }
}
