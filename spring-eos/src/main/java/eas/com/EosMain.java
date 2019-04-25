package eas.com;

import eas.com.inside.Bean2;
import eas.com.inside.EosConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EosMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(EosConfig.class);
        Bean2 bean = annotationConfigApplicationContext.getBean(Bean2.class);
        System.out.println("Bean: " + bean);
        //System.out.println("Bean3 some Action: " + bean.getBean3().someAction());
    }
}
