package tech.insight.observe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Max
 * @description
 * @date 2025/6/23 17:36
 */
public class Publisher {
    private List<EventListener> listenerList = new ArrayList<>();
    private Map<Class<? extends Event>, List<EventListener>> listenerMap = new HashMap<>();
    public void subscribe(EventListener listener, Class<? extends Event> eventClass) {
        listenerMap.computeIfAbsent(eventClass, k -> new ArrayList<>()).add(listener);
    }
    public void publish(Event event) {
       Class<? extends Event> clazz = event.getClass();
        List<EventListener> eventListeners = listenerMap.get(clazz);
        if (eventListeners == null)
            throw new RuntimeException("no listener for event " + clazz.getName());
        for (EventListener listener : eventListeners) {
            listener.onEvent(event);
        }
    }
}
