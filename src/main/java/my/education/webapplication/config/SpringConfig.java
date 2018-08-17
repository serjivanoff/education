package my.education.webapplication.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "my.education.webapplication.**")
public class SpringConfig {
}
