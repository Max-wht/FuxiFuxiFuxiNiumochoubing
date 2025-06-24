package tech.insight.observe;

/**
 * @author Max
 * @description
 * @date 2025/6/23 17:42
 */
public interface Event {
    long timestamp();
    Object source();
}
