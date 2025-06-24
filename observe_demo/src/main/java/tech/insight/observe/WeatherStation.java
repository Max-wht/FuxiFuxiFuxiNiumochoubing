package tech.insight.observe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Max
 * @description
 * @date 2025/6/23 17:21
 */
public class WeatherStation {
    private final Publisher publisher;

    public WeatherStation(Publisher publisher) {
        this.publisher = publisher;
    }

    private String getInfo(){
        if(new Random().nextBoolean()) {
            return "晴天";
        }
        return "阴天";
    }
    public void run() {
        while (true) {
            String info = getInfo();
            publisher.publish(new WeatherUpdateEvent(info));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
