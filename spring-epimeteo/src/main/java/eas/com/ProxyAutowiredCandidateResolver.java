package eas.com;

import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.SimpleAutowireCandidateResolver;
import org.springframework.stereotype.Component;

public class ProxyAutowiredCandidateResolver extends SimpleAutowireCandidateResolver {

    @Override
    public Object getSuggestedValue(DependencyDescriptor descriptor) {
        System.out.println("Entrando a la custom");
        String dependencyClassName = descriptor.getDependencyType().getSimpleName();
        if (dependencyClassName.endsWith("Interface")) {
            System.out.println("Entrando a la custom");
            return null;
            //return MyProxyUtil.getInstance(descriptor.getDependencyType());
        }

        return new CustomCglibAopProxy(descriptor);
    }

}
