package tech.insight.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Max
 * @description
 * @date 2025/6/23 18:35
 */
@SpringBootApplication
public class Applicaiton {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Applicaiton.class, args);
    }
}
