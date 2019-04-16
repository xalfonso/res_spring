package eas.com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolverEduardo());
        context.register(BeansConfig.class);
        context.refresh();
        IBean2 bean2 = context.getBean("bean2", Bean2.class);
        long init = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            bean2.getBean3().doSomeThing();
        }
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (end - init));
    }
}
