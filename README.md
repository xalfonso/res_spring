# res_spring. Research in Spring framework

###1. Projects
 * SpringGea
   1. Dependencies:
   org.springframework > spring-context > 4.3.3.RELEASE
   2. Tips:
   Xml context configuration, read data from properties file in xml context, import one xml context in other, load several xml context, constructor injection, setter injection, init and destroy method bean.
   
* SpringUrano
   1. Dependencies:
   org.springframework > spring-context > 4.3.3.RELEASE
   2. Tips:
   Annotation context configuration with XML context configuration, configure for scanning package from xml file, constructor injection, setter injection, use of properties file for inject value, init and destroy method bean.
   Use of @Component, @Value, @Autowired, @Qualifier, @PostConstruct, @PreDestroy.
* SpringCronos
   1. Dependencies:
   org.springframework > spring-context > 4.3.3.RELEASE
   2. Tips:
   Java configuration with annotation configuration, configure for scanning package from java class, constructor injection, setter injection, use of properties file for inject value (Configure from java class), init and destroy method bean.
   Use of @Component, @Value, @Autowired, @Qualifier, @PostConstruct, @PreDestroy
* SpringRea
   1. Dependencies:
   org.springframework > spring-context > 4.3.3.RELEASE
   2. Tips:
   Java configuration, configure for scanning package from java class, constructor injection, setter injection,
        use of properties file for inject value (Configure from java class), init and destroy method bean.
        Use of @Value, @PostConstruct, @PreDestroy.
* SpringJapeto
   1. Dependencies:
   org.springframework > spring-webmvc > 4.3.3.RELEASE
   2. Tips:
        Web application(Spring MVC),  Xml context configuration, import one xml context in other,
        Application with different modules, each module have own xml configuration, test, and source code.
        Each module have a same structure: web, facade, service, dao. The web package contain the Interface for the front End Client.
        The facade package contain the interface for other module that want use functions of this module.
