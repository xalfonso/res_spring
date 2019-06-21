package eas.com.web.managed;

import eas.com.web.wrapper.CustomHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eduardo Alfonso Sanchez
 */
@Slf4j
public class CustomFilterSession extends OncePerRequestFilter {

    public static Map<String, HttpSession> httpSessionMap = new ConcurrentHashMap<>();


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        CustomHttpServletRequestWrapper httpServletRequestWrapper = new CustomHttpServletRequestWrapper(httpServletRequest);

        filterChain.doFilter(httpServletRequestWrapper, httpServletResponse);
    }
}
