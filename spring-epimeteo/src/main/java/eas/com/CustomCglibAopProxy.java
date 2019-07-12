package eas.com;

import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

public class CustomCglibAopProxy implements AopProxy, Serializable, MethodInterceptor {
    DependencyDescriptor descriptor;

    public CustomCglibAopProxy() {
    }


    public CustomCglibAopProxy(final DependencyDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        /*if (AopUtils.isAopProxy(bean3) && bean3 instanceof Advised) {
            Object target = null;
            try {
                target = ((Advised) bean3).getTargetSource().getTarget();
                bean3 = (Bean3) target;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }*/
        return null;
    }

    public Object getProxy() {
        return getProxy(null);
    }

    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
