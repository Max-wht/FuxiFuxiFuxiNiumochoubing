package tech.insight.observe;

import java.time.Instant;

/**
 * @author Max
 * @description
 * @date 2025/6/23 17:42
 */
public abstract class BaseEvent implements Event{
    private final long timestamp;
    protected BaseEvent() {
        this.timestamp = Instant.now().toEpochMilli();
    }
    @Override
    public long timestamp() {
        return timestamp;
    }
}
