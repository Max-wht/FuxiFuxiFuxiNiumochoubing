package tech.insight.spring.listener;

import org.springframework.context.event.EventListener;
import tech.insight.spring.event.RandomEvent;

/**
 * @author Max
 * @description
 * @date 2025/6/23 19:08
 */
public class RandomEventListener {

    @EventListener
    public void onRandomEvent (RandomEvent event) {
        System.out.println("RandomEventListener: " + event.getSource());
    }
}
