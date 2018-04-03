package eas.com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web Initializer Java Configuration
 *
 * @author esanchez
 */
public class SystemWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
