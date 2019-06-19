package eas.com.web.managed;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "registration")
@ViewScoped
@Getter
@Setter
public class RegistrationBean {

    private String userName;
    private String operationMessage;
    private String userInfo;

    private List<String> listUser;

    public RegistrationBean() {
        listUser = new ArrayList<>();
        this.userInfo = SecurityContextHolder.getContext().getAuthentication().toString();
    }

    public void createNewUser() {
        System.out.println("Call to createNewUser: " + this.userName);
        listUser.add(this.userInfo);
    }
}
