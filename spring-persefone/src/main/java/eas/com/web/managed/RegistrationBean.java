package eas.com.web.managed;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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


    /*@ManagedProperty("#{kSecurityContextRepository}")
    private KSecurityContextRepository kSecurityContextRepository;*/

    /*@ManagedProperty("#{applicationContext}")
    private ApplicationContext applicationContext;*/

    /**
     * Constructor.
     */
    public RegistrationBean() {
        listUser = new ArrayList<>();
        this.userInfo = SecurityContextHolder.getContext().getAuthentication().toString();
    }

    public void createNewUser() {
        log.info("Call to createNewUser: " + this.userName);
        listUser.add(this.userInfo);
    }

    public void showSession() {

        Optional<SecurityContext> any = FactoryTemp.buildObject().securityContextMap.values().stream().filter(securityContext -> !securityContext.getAuthentication().getName().equalsIgnoreCase("anonymousUser")).findAny();


        log.info("Show sessions map: " + FactoryTemp.buildObject());
        FactoryTemp.buildObject().securityContextMap.forEach((s, session) -> {
            log.info("Key: " + s + " Value: " + session);
        });
    }
}
