package eas.com;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.util.*;

public class ContextAnnotationAutowireCandidateResolverEduardo extends ContextAnnotationAutowireCandidateResolver {

    @Override
    protected Object buildLazyResolutionProxy(final DependencyDescriptor descriptor, @Nullable final String beanName) {
        Assert.state(this.getBeanFactory() instanceof DefaultListableBeanFactory, "BeanFactory needs to be a DefaultListableBeanFactory");
        final DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)this.getBeanFactory();
        TargetSource ts = new TargetSource() {
            public Class<?> getTargetClass() {
                return descriptor.getDependencyType();
            }

            public boolean isStatic() {
                return false;
            }

            public Object getTarget() {
                Object target = beanFactory.doResolveDependency(descriptor, beanName, (Set)null, (TypeConverter)null);
                if (target == null) {
                    Class<?> type = this.getTargetClass();
                    if (Map.class == type) {
                        return Collections.emptyMap();
                    } else if (List.class == type) {
                        return Collections.emptyList();
                    } else if (Set.class != type && Collection.class != type) {
                        throw new NoSuchBeanDefinitionException(descriptor.getResolvableType(), "Optional dependency not present for lazy injection point");
                    } else {
                        return Collections.emptySet();
                    }
                } else {
                    return target;
                }
            }

            public void releaseTarget(Object target) {
            }
        };
        ProxyFactory pf = new ProxyFactory();
        pf.setTargetSource(ts);
        pf.setFrozen(true);
        pf.setOptimize(true);
        Class<?> dependencyType = descriptor.getDependencyType();
        if (dependencyType.isInterface()) {
            pf.addInterface(dependencyType);
        }

        return pf.getProxy(beanFactory.getBeanClassLoader());
    }
}
