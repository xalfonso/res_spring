package eas.com.module1.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestNotAuthenticationHandler implements AuthenticationEntryPoint {
    static ObjectMapper MAPPER = new ObjectMapper();


    @Override
    public void commence(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        String bodyResponse = MAPPER.writeValueAsString(new Message("Usted no se ha autenticado"));
        printWriter.write(bodyResponse);
        printWriter.flush();
    }
}
