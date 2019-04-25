package eas.com.inside.inner;

import eas.com.outside.Bean3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Bean1 {

    @Autowired
    private Bean3 bean3;

    public Bean3 getBean3() {
        return bean3;
    }
}
