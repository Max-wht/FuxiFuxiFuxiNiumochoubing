package tech.insight.observe;

import java.util.function.Consumer;

/**
 * @author Max
 * @description
 * @date 2025/6/23 17:21
 */
public class User implements EventListener{

    public final String name;
    public final Consumer<String> infoConsumer;
    public User (String name, Consumer<String> infoConsumer) {
        this.name = name;
        this.infoConsumer = infoConsumer;

    }
    public void receiveInfo(String info) {
        infoConsumer.accept(info);
    }
    @Override
    public void onEvent(Event event) {
        if (event instanceof WeatherUpdateEvent) {
            receiveInfo(event.source().toString());
        }
    }
}
