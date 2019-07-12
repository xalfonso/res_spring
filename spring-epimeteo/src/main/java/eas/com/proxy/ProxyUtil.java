package eas.com.proxy;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

public class ProxyUtil {

    public static <T> T unProxy(T proxy) {
        Object target = proxy;
        if (AopUtils.isAopProxy(proxy) && proxy instanceof Advised) {
            try {
                target = ((Advised) proxy).getTargetSource().getTarget();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return (T) target;
    }
}
