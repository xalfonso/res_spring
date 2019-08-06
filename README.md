# res_spring. Research in Spring framework.

Projects
1. SpringGea
   1. Main Dependencies:
   org.springframework > spring-context > 4.3.3.RELEASE
   2. Tips:
   Xml context configuration, read data from properties file in xml context, import one xml context in other, load several xml context, constructor injection, setter injection, init and destroy method bean.   
2. SpringUrano
   1. Main Dependencies:
   org.springframework > spring-context > 4.3.3.RELEASE
   2. Tips:
   Annotation context configuration with XML context configuration, configure for scanning package from xml file, constructor injection, setter injection, use of properties file for inject value, init and destroy method bean.
   Use of @Component, @Value, @Autowired, @Qualifier, @PostConstruct, @PreDestroy.
3. SpringCronos
   1. Main Dependencies:
   org.springframework > spring-context > 4.3.3.RELEASE
   2. Tips:
   Java configuration with annotation configuration, configure for scanning package from java class, constructor injection, setter injection, use of properties file for inject value (Configure from java class), init and destroy method bean.
   Use of @Component, @Value, @Autowired, @Qualifier, @PostConstruct, @PreDestroy
4. SpringRea
   1. Main Dependencies:
   org.springframework > spring-context > 4.3.3.RELEASE
   2. Tips:
   Java configuration, configure for scanning package from java class, constructor injection, setter injection,
        use of properties file for inject value (Configure from java class), init and destroy method bean.
        Use of @Value, @PostConstruct, @PreDestroy.
5. SpringFebe
   1. Main Dependencies
  org.springframework > spring-context > 4.3.3.RELEASE  
   2. Tips:
  Full Java configuration (Without Annotation in the business class and without XML configuration), use of properties file for inject value (Configure from java class), init and destroy method bean, use default destroy method.  
6. SpringJapeto
   1. Main Dependencies:
   org.springframework > spring-webmvc > 4.3.3.RELEASE
   2. Tips:
        Web application(Spring MVC),  Xml context configuration, import one xml context in other,
        Application with different modules, each module have own xml configuration, test, and source code.
        Each module have a same structure: web, facade, service, dao. The web package contain the Interface for the front End Client.
        The facade package contain the interface for other module that want use functions of this module.
        Load the list of value from file properties, for inject into Map in one controller
7. SpringTemis
   1. Main Dependencies:
   org.springframework > spring-webmvc > 4.3.3.RELEASE;
   org.aspectj > aspectjrt > 1.8.9;
   org.aspectj > aspectjweaver > 1.8.9
   2. Tips:
        Web application(Spring MVC), AOP: Use of @Aspect, @Pointcut, @After, @Before, @AfterReturning, execution,
		within, target, bean, @target, @args, @within, @annotation
8. SpringOceano
   1. Main Dependencies:
   org.springframework.ws > spring-ws-core > 2.4.0.RELEASE;
   org.jdom > jdom > 2.0.1;
   jaxen > jaxen > 2.0.1;
   wsdl4j > wsdl4j > 1.6.3
   2. Tips:
        Web Service Application: Publish Web Service
9. SpringTea
   1. Main Dependencies:
   org.springframework > spring-webmvc > 4.3.3.RELEASE;
   javax.ws.rs > javax.ws.rs-api > 2.0;
   org.glassfish.jersey.core > jersey-client > 2.21;
   com.google.code.gson > gson > 2.4
   2. Tips:
        Web application(Spring MVC), consume api rest, deserialize json
10. SpringCeo
    1. Main Dependencies:
    org.springframework > spring-webmvc > 4.3.4.RELEASE;
    org.springframework > spring-orm > 4.3.4.RELEASE;
    org.hibernate > hibernate-core > >5.2.4.Final;
    com.mchange > c3p0 > 0.9.5.2;
    mysql > mysql-connector-java > 5.1.39;
    javax.servlet > javax.servlet-api > 3.1.0;
    javax.servlet.jsp.jstl > jstl-api > 1.2;
    taglibs > standard > 1.1.2;
    log4j > log4j > 1.2.17
    2. Tips:
         Spring MVC, Hibernate, JPA Annotation,Spring XML configuration with use of annotation, configure connection pool with c3p0 lib, load different properties file, Example of multi tier application
11. SpringTetis
    1. Main Dependencies:
    org.springframework > spring-core > 4.3.5.RELEASE;
    org.springframework > spring-context > 4.3.5.RELEASE   
    2. Tips:
         Spring Expression Language 
		
12. SpringTia (from SpringJapeto)
    1. Main Dependencies:
    org.springframework > spring-webmvc > 4.3.3.RELEASE
    2. Tips: @Scheduled and @Async method. Example in TaskService.java.
        With the @Async we can pass parameter and return some value; in this case we need to call the method
        With the @Scheduled wen cannot pass parameter neither return some value; in this case we do not need call directly the method,
        the method is called automatically in relation with the expression (cron expression)
	And the same of SpringJapeto
13. spring-hisperon
    1. Main Dependencies
    org.springframework > spring-webmv > 4.3.15.RELEASE;
    javax.servlet > javax.servlet-api > 4.0.0;
    javax.servlet.jsp > javax.servlet.jsp-api > 2.3.1;
    javax.servlet > jstl > 1.2
    com.fasterxml.jackson.core > jackson-cor > 2.8.11
    com.fasterxml.jackson.core > jackson-annotations > 2.8.11
    com.fasterxml.jackson.core > jackson-databind > 2.8.11
    jquery > core > 1.12.4
    2. Tips: Spring MVC, Spring Java Configuration, Enable Cross Origin in specific controller method, Call spring-crios project from post form, Consume Rest Web Services With JQuery
14. spring-mnemosine
    1. Main Dependencies
    org.springframework > spring-webmvc > 4.3.15.RELEASE;
    javax.servlet > javax.servlet-api > 4.0.0;
    com.fasterxml.jackson.core > jackson-cor > 2.8.11
    com.fasterxml.jackson.core > jackson-annotations > 2.8.11
    com.fasterxml.jackson.core > jackson-databind > 2.8.11
    2. Tips: Spring MVC, Api Rest, Spring Java Configuration, AsyncRestTemplate, AsyncRequestCallBack, ResponseExtractor,          
       ListenableFuture, Future Call Back
15. spring-crios (from spring-hisperon)
    1. Main Dependencies
    org.springframework > spring-webmv > 4.3.15.RELEASE;
    javax.servlet > javax.servlet-api > 4.0.0;
    javax.servlet.jsp > javax.servlet.jsp-api > 2.3.1;
    javax.servlet > jstl > 1.2;
    org.springframework.security > spring-security-config > 4.2.5.RELEASE;
    org.springframework.security > spring-security-web > 4.2.5.RELEASE
    2. Tips: Spring MVC, Spring Security, Spring Java Configuration. Conditional Authentication for avoid to go the database again
16. spring-zeus
    1. Main Dependencies
    org.springframework > spring-webmv > 4.3.16.RELEASE;
    javax.servlet > javax.servlet-api > 4.0.0;
    javax.servlet.jsp > javax.servlet.jsp-api > 2.3.1;
    javax.servlet > jstl > 1.2;
    org.webjars.bower > jquery > 3.3.1
    2. Tips: Spring MVC, WebJar: Use css, js file from jar, in this case, i am using jquery from jar. Using external proyect create by me for store js and css: spring-apolo
17. spring-apolo
    1. Tips: Project for contains static file: css and js and be include for other project. This project do not have dependency with spring framework
18. spring-atenea
    1. Tips: Rest Aplication with Spring Security and KeyCloak.
    2. Main Dependencies
    org.springframework > spring-webmv > 5.0.12.RELEASE;
    javax.servlet > javax.servlet-api > 4.0.1;
    com.fasterxml.jackson.core > jackson-databind > 2.9.6;
    org.springframework.security > spring-security-web > 5.0.11;
    org.springframework.security > spring-security-config > 5.0.11;
    org.keycloak > keycloak-spring-security-adapter > 4.8.3.Final
19. spring-persefone
    1. Tips: Web Aplication (JSF+Primefaces) with Spring Security and KeyCloak.
    2. Main Dependencies
    org.springframework > spring-webmv > 5.0.12.RELEASE;
    javax.servlet > javax.servlet-api > 4.0.1;
    com.fasterxml.jackson.core > jackson-databind > 2.9.6;
    org.springframework.security > spring-security-web > 5.0.11;
    org.springframework.security > spring-security-config > 5.0.11;
    org.keycloak > keycloak-spring-security-adapter > 4.8.3.Final
    com.sun.faces > jsf-api > 2.1.27
    javax.el > javax.el-api > 3.0.0
    org.primefaces > primefaces > 6.2
 20. spring-metis
    1. Tips: Web Aplication WebServices with Spring Security and Spring Session in Memory.
 21. spring-eos
    1. Tips: Example of exclude beans of spring context. Use of @ComponentScan(excludeFilters = ...
 22. spring-epimeteo: Performance Test of Spring Proxy and use of Lazy
 23. spring-leto
 <ul>
	<li>Gradle Application</li>
	<li>Web Applicaction With Spring 5</li>
	<li>Example of Upload File in Spring Rest Controller. Application made with web.xml</li>
	<li>Example of @RequestPart for send json and file together</li>
	<li>Example of Test that consume the web service and send File and Json</li>
</ul>
24. spring-ares
<ul>
  <li>Gradle Application</li>
  <li>Spring Application</li>
  <li>Web Rest Service Applicaction</li>  
  <li>Basic Spring Security Application Configured in XML</li>  
</ul>
25. spring-heracles
<ul>
  <li>Gradle Application</li>
  <li>Spring Application</li>
  <li>Web Rest Service Applicaction</li>  
  <li>Spring Security Application Configured in XML</li>
  <li>Custom Filter for get a Token of Header and triger the Authentication Manager if is neccesary</li>  
</ul>
