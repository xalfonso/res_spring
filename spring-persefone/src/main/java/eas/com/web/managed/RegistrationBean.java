package eas.com.web.managed;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Some dummy bean.
 *
 * @author Eduardo Alfonso Sanchez
 */
@ManagedBean(name = "registration")
@ViewScoped
@Getter
@Setter
public class RegistrationBean {

    private String userName;
    private String operationMessage;
    private String userInfo;

    private List<String> listUser;

    /**
     * Constructor.
     */
    public RegistrationBean() {
        listUser = new ArrayList<>();
        this.userInfo = SecurityContextHolder.getContext().getAuthentication().toString();
    }

    /**
     * Create new user.
     */
    public void createNewUser() {
        System.out.println("Call to createNewUser: " + this.userName);
        listUser.add(this.userInfo);
    }
}
