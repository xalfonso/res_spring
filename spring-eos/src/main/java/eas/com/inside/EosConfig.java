package eas.com.inside;

import eas.com.inside.inner.Bean1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Two way of exclude the bean1 class of spring context
 */
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Bean1.class))
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "eas.com.inside.inner.*"))
@Configuration
public class EosConfig {
}
