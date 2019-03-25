package eas.com.module1.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestLogoutSuccessHandler implements LogoutSuccessHandler {
    private static ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        String bodyResponse = MAPPER.writeValueAsString(new Message("Usted ha cerrado session correctamente"));
        printWriter.write(bodyResponse);
        printWriter.flush();
    }
}
