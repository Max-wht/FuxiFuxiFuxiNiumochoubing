package tech.insight.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Max
 * @description
 * @date 2025/6/23 18:47
 */
public class RandomEvent extends ApplicationEvent {
    public RandomEvent(Object source) {
        super(source);
    }
}
