package eas.com;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

//@Component
public class AutowireCandidateResolverConfigurer implements BeanFactoryPostProcessor {


    private AutowireCandidateResolver autowireCandidateResolver = new ContextAnnotationAutowireCandidateResolverEduardo();

    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory bf = (DefaultListableBeanFactory) beanFactory;
        bf.setAutowireCandidateResolver(autowireCandidateResolver);


    }

    public AutowireCandidateResolver getAutowireCandidateResolver() {
        return autowireCandidateResolver;
    }

    public void setAutowireCandidateResolver(

            AutowireCandidateResolver autowireCandidateResolver) {
        this.autowireCandidateResolver = autowireCandidateResolver;
    }
}
