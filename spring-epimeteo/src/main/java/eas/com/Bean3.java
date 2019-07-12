package eas.com;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bean3 implements IBean3 {

    private String name = "Load eas.com.Bean3";

    @PostConstruct
    public void init() {
        System.out.println("Load eas.com.Bean3");
    }


    public void doSomeThing() {
        System.out.println("Execute some action from bean 3");
    }
}
