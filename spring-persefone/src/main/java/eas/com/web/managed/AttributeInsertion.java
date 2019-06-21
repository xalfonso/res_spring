package eas.com.web.managed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Some dummy bean.
 *
 * @author Eduardo Alfonso Sanchez
 */
@Slf4j
@ManagedBean(name = "attributeInsertion")
@ViewScoped
@Getter
@Setter
public class AttributeInsertion {

    private String attributeName;
    private String attributeValue;

    private Map<String, String> sessionAttributes = new HashMap<>();

    /**
     * Constructor.
     */
    public AttributeInsertion() {
        this.updateAttributesMap();
    }

    /**
     * Create new user.
     */
    public void addAttributeToSession() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        req.getSession().setAttribute(attributeName, attributeValue);
        attributeName = null;
        attributeValue = null;
        this.updateAttributesMap();
    }

    public void testSession() {


    }

    public void updateAttributesMap() {
        this.sessionAttributes = new HashMap<>();
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession httpSession = req.getSession();
        Enumeration<String> attributeNames = httpSession.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            sessionAttributes.put(key, httpSession.getAttribute(key).toString());
        }
    }

    @AllArgsConstructor
    class DummyClass {
        private String name;

    }
}
