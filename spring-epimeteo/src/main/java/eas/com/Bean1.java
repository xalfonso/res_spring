package eas.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bean1 implements IBean1 {

    private String name = "Load eas.com.Bean1";

    @Lazy
    @Autowired
    private IBean3 bean3;

    @PostConstruct
    public void init() {
        System.out.println("Load eas.com.Bean1");
    }
}
