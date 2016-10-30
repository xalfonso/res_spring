package eas.com;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/29/2016.
 */
@Aspect
@Component
public class SystemWebTrace {

    private final static Logger LOGGER = Logger.getLogger(SystemServiceTrace.class.getName());

    /**
     * PointCut for re-use after
     * Create a pointCut with name: anyMethodInWeb() for all method inside web package
     */
    @Pointcut("within(eas.com.web.*)")
    public void anyMethodInWeb(){}


    /**
     * PointCut for re-use after
     * Create a pointCut with name: anyMethodListAction() for all listAction methods
     */
    @Pointcut("execution(* *.listAction(..))")
    public void anyMethodListAction(){}

    /**
     * In this case i am using the anyMethodListAction() point cut defined before
     */
    @After("anyMethodListAction()")
    public void AfterAnyMethodListAction(JoinPoint joinPoint){
        LOGGER.log(Level.INFO, "(AfterAnyMethodListAction) @After Method  long Description: " + joinPoint.getSignature().toLongString());
    }

    /**
     * In this case i am using the anyMethodListAction() && anyMethodInWeb() point cut defined before
     */
    @After("anyMethodListAction() && anyMethodInWeb()")
    public void AfterAnyMethodListActionInWeb(JoinPoint joinPoint){
        LOGGER.log(Level.INFO, "(AfterAnyMethodListActionInWeb) @After Method  long Description: " + joinPoint.getSignature().toLongString());
    }


    /**
     * PointCut for re-use after
     * Create a pointCut with name: anyMethodInService() for all method inside web package
     */
    @Pointcut("within(eas.com.service.*)")
    public void anyMethodInService(){}

    /**
     * PointCut for re-use after
     * Create a pointCut with name: anyMethodAnnotatedWithAnnotationTest() for all method annotated with AnnotationTest
     */
    @Pointcut("@annotation(eas.com.AnnotationTest)")
    public void anyMethodAnnotatedWithAnnotationTest(){}


    @Before("anyMethodInService() && anyMethodAnnotatedWithAnnotationTest()")
    public void anyMethodInServiceWithAnnotationTest(JoinPoint joinPoint){
        LOGGER.log(Level.INFO, "(anyMethodInServiceWithAnnotationTest) @Before Method  long Description: " + joinPoint.getSignature().toLongString());
    }

    /**
     * PointCut for re-use after
     * Create a pointCut with name: anyMethodInsideTheClassThatImplementInterfaceTest() for all method inside of class
     * That implement the InterfaceTest interface
     */
    @Pointcut("target(eas.com.InterfaceTest)")
    public void anyMethodInsideTheClassThatImplementInterfaceTest(){}

    @Before("anyMethodInService() && anyMethodInsideTheClassThatImplementInterfaceTest()")
    public void AnyBlaBla(JoinPoint joinPoint){
        LOGGER.log(Level.INFO, "(AnyBlaBla) @Before Method  long Description: " + joinPoint.getSignature().toLongString());
    }

    /**
     * PointCut for re-use after
     * Create a pointCut with name: anyMethodInsideTheObjectAnnotatedWithAnnotationTest() for all method of object
     * That is annotated with AnnotationTest
     *
     * I do not the difference between @within and @target!
     */
    @Pointcut("@target(eas.com.AnnotationTest)")
    public void anyMethodInsideTheObjectAnnotatedWithAnnotationTest(){}


    @Before("anyMethodInService() && anyMethodInsideTheObjectAnnotatedWithAnnotationTest()")
    public void anyMethodPloPloPlo(JoinPoint joinPoint){
        LOGGER.log(Level.INFO, "(anyMethodPloPloPlo) @Before Method  long Description: " + joinPoint.getSignature().toLongString());
    }

    /**
     * PointCut for re-use after
     * Create a pointCut with name: anyMethodInsideTheObjectAnnotatedWithAnnotationTest() for all method of object
     * That is annotated with AnnotationTest
     * I do not the difference between @within and @target!
     */
    @Pointcut("@within(eas.com.AnnotationTest)")
    public void anyMethodInsideTheObjectAnnotatedWithAnnotationTest1(){}


    @Before("anyMethodInService() && anyMethodInsideTheObjectAnnotatedWithAnnotationTest1()")
    public void anyMethodPloPloPlo1(JoinPoint joinPoint){
        LOGGER.log(Level.INFO, "(anyMethodPloPloPlo1) @Before Method  long Description: " + joinPoint.getSignature().toLongString());
    }

    /**
     * PointCut for re-use after
     * Create a pointcut with name: anyMethodInsideBeanTestService() for all methods
     * inside the bean with id = testService
     */
    @Pointcut("bean(testService)")
    public void anyMethodInsideBeanTestService(){}


    @After("anyMethodInsideBeanTestService()")
    public void anyPaPaPaPa(JoinPoint joinPoint){
        LOGGER.log(Level.INFO, "(anyPaPaPaPa) @After Method  long Description: " + joinPoint.getSignature().toLongString());
    }


}
