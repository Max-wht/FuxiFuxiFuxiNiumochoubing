package tech.insight.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Max
 * @description
 * @date 2025/6/23 19:24
 */
public class RegisterEvent extends ApplicationEvent {
    public RegisterEvent(String source) {
        super(source);
    }

    public String getUser() {
        return (String) getSource();
    }
}
