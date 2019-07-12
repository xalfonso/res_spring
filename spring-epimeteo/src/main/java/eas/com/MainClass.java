package eas.com;

import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;

import java.io.IOException;

public class MainClass {

    private static AutowireCandidateResolver autowireCandidateResolver = new ContextAnnotationAutowireCandidateResolverEduardo();

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ProxyAutowiredCandidateResolver());

        //context.getDefaultListableBeanFactory().setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolverEduardo());
        context.register(BeansConfig.class);
        context.refresh();
        IBean2 bean2 = context.getBean("bean2", Bean2.class);
        long init = System.currentTimeMillis();
        /*for (int i = 0; i < 1; i++) {
            bean2.getBean3().doSomeThing();
        }*/

        bean2.getBean3().doSomeThing();
        System.out.println("Segunda Vez");
        bean2.getBean3().doSomeThing();


        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (end - init));

        int a = System.in.read();
    }
}
