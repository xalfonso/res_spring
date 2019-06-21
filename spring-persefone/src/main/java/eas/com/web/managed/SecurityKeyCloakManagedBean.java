package eas.com.web.managed;

import lombok.Getter;
import lombok.Setter;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.Session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Managed bean as example for getting the refresh token of keycloak.
 *
 * @author Eduardo Alfonso Sanchez
 */
@Getter
@Setter
@ManagedBean(name = "securityKeyCloakManagedBean")
@SessionScoped
public class SecurityKeyCloakManagedBean {

    private String refreshToken;

    private String sessionId;

    /**
     * Constructor.
     */
    public SecurityKeyCloakManagedBean() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof KeycloakPrincipal) {
                if (((KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getKeycloakSecurityContext() instanceof RefreshableKeycloakSecurityContext) {
                    this.refreshToken = ((RefreshableKeycloakSecurityContext) ((KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getKeycloakSecurityContext()).getRefreshToken();
                }
            }
        }

        Map<String, Session> allSession = SpringConfiguration.allSession;

        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        sessionId = req.getSession().getId();
    }
}
