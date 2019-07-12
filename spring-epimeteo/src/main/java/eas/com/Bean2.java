package eas.com;

import eas.com.proxy.ProxyUtil;
import lombok.experimental.ExtensionMethod;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static eas.com.proxy.ProxyUtil.unProxy;

@ExtensionMethod(value = ProxyUtil.class)
@Component
public class Bean2 implements IBean2 {

    private String name = "Load eas.com.Bean2";

    //@Lazy
    @Autowired
    private IBean3 bean3;

    @PostConstruct
    public void init() {

        System.out.println("Load eas.com.Bean2");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setBean3(Bean3 bean3) {
        this.bean3 = bean3;
    }

    public IBean3 getBean3() {
        /*if (AopUtils.isAopProxy(bean3) && bean3 instanceof Advised) {
            Object target = null;
            try {
                target = ((Advised) bean3).getTargetSource().getTarget();
                bean3 = (Bean3) target;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }*/
        return bean3;



        //return unProxy(bean3);
    }
}
