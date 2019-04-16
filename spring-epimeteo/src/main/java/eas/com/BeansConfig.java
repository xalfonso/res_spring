package eas.com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(lazyInit = false)
@Configuration()
public class BeansConfig implements SomeInterface {


    public void someMethod() {
    }
}
