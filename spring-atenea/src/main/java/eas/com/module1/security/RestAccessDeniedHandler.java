package eas.com.module1.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eas.com.common.entity.Student;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    private static ObjectMapper MAPPER = new ObjectMapper();


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        String bodyResponse = MAPPER.writeValueAsString(new Message("Usted no tiene acceso al recurso solicitado"));
        printWriter.write(bodyResponse);
        printWriter.flush();
    }
}
