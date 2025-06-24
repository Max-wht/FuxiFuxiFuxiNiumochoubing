package tech.insight.spring.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.insight.spring.event.RegisterEvent;

/**
 * @author Max
 * @description
 * @date 2025/6/23 18:36
 */
@RestController
@RequestMapping("/observe")
public class LoginController {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private ApplicationEventMulticaster eventMulticaster;

    @PostConstruct
    public void init() {
        System.out.println(context == eventPublisher);
    }

    @GetMapping("/ttt")
    public String register(@RequestParam("name") String s) {
        System.out.println("register");
        eventPublisher.publishEvent(new RegisterEvent(s));

        return "OK";
    }
}
