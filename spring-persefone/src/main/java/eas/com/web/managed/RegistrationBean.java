package eas.com.web.managed;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "registration")
@ViewScoped
@Getter
@Setter
public class RegistrationBean {

    private String userName;
    private String operationMessage;
    private String userInfo;

    public RegistrationBean() {
        this.userInfo = SecurityContextHolder.getContext().getAuthentication().toString();
    }

    public void createNewUser() {
       System.out.println("Call to createNewUser: " + this.userName);

    }
}
