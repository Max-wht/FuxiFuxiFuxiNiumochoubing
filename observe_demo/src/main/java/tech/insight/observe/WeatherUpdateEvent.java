package tech.insight.observe;

/**
 * @author Max
 * @description
 * @date 2025/6/23 18:00
 */
public class WeatherUpdateEvent extends BaseEvent {
    private final String info;
    public WeatherUpdateEvent(String info) {
        this.info = info;
    }

    @Override
    public Object source() {
        return info;
    }
}
