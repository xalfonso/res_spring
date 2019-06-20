package eas.com.web.managed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Some dummy bean.
 *
 * @author Eduardo Alfonso Sanchez
 */
@Slf4j
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

    public void testSession() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession();
        session.setAttribute("example of Attribute", new DummyClass("Hello"));
        log.info(SpringConfiguration.allSession.values().toString());
    }


    @AllArgsConstructor
    class DummyClass {
        private String name;

    }
}
