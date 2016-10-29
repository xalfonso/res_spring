package eas.com;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by eduardo on 10/27/2016.
 *
 * One aspect is the cross-cutting functionality that will be executed of modular way and
 * it will be independent of the rest of application
 *
 * Class for intercept the method of the controller class with AOP
 */
@Component
@Aspect
public class SystemServiceTrace {
    private final static Logger LOGGER = Logger.getLogger(SystemServiceTrace.class.getName());


    /**
     * Execute before the method intercepted
     * @param joinPoint
     */
    @Before("execution(* eas.com.service.TestService.list(..))")
    public void listBeforeTrace(JoinPoint joinPoint) {
        LOGGER.log(Level.INFO, "(listBeforeTrace) @Before Method  Name: " + joinPoint.getSignature().getName()); /*Output: listAction*/
        LOGGER.log(Level.INFO, "(listBeforeTrace) @Before Method  short Description: " + joinPoint.getSignature().toShortString()); /*Output: TestController.listAction()*/
        LOGGER.log(Level.INFO, "(listBeforeTrace) @Before Method  long Description: " + joinPoint.getSignature().toLongString()); /*Output: public java.lang.String eas.com.web.TestController.listAction()*/
    }

    /**
     *  Execute after the method intercepted
     * @param joinPoint
     */
    @After("execution(* eas.com.service.TestService.list(..))")
    public void listAfterTrace(JoinPoint joinPoint) {
        LOGGER.log(Level.INFO, "(listAfterTrace) @After Method  Name: " + joinPoint.getSignature().getName()); /*Output: listAction*/
        LOGGER.log(Level.INFO, "(listAfterTrace) @After Method  Modifier: " + Modifier.toString(joinPoint.getSignature().getModifiers())); /*Output: public*/
        LOGGER.log(Level.INFO, "(listAfterTrace) @After Method  Declarative Type Name: " + joinPoint.getSignature().getDeclaringTypeName()); /*Output: eas.com.web.TestController*/
    }

    /**
     *  Execute after returning the method intercepted
     *
     *  In this case, two methods are executed, insert(String, String) and insert(string)
     *  because I do not specified the  parameters. @see insertAfterReturningTraceOneParameter
     * @param joinPoint
     */
    @AfterReturning(pointcut = "execution(* eas.com.service.TestService.insert(..))", returning = "result")
    public void insertAfterReturningTrace(JoinPoint joinPoint, Object result){
        LOGGER.log(Level.INFO, "(insertAfterReturningTrace) @AfterReturning Method  long Description: " + joinPoint.getSignature().toLongString());
        LOGGER.log(Level.INFO, "(insertAfterReturningTrace) @AfterReturning Method  Argument 1: " + joinPoint.getArgs()[0].toString());
        LOGGER.log(Level.INFO, "(insertAfterReturningTrace) @AfterReturning Method  Returning Value: " + result.toString());
    }

    /**
     *  Execute after returning the method intercepted
     *
     *  In this case only one method is executed: insert(string)
     *  because I specified the parameters: args(value). 
     *  With args we can restrict the parameter that must have the method to intercept
     * @param joinPoint
     */
    @AfterReturning(value = "execution(* eas.com.service.TestService.insert(..)) && args(value)",returning = "result")
    public void insertAfterReturningTraceOneParameter(JoinPoint joinPoint, Object value, Object result){
        LOGGER.log(Level.INFO, "(insertAfterReturningTraceOneParameter) @AfterReturning Method  long Description: " + joinPoint.getSignature().toLongString());
        LOGGER.log(Level.INFO, "(insertAfterReturningTraceOneParameter) @AfterReturning Method  Argument 1: " + joinPoint.getArgs()[0].toString());
        LOGGER.log(Level.INFO, "(insertAfterReturningTraceOneParameter) @AfterReturning Method  Argument 1: " + value.toString());
        LOGGER.log(Level.INFO, "(insertAfterReturningTrace) @AfterReturning Method  Returning Value: " + result.toString());

    }


}
