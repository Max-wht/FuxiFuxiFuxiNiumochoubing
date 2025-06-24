package tech.insight.spring;

import java.lang.annotation.*;

/**
 * @author Max
 * @description
 * @date 2025/6/17 20:41
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimestampRequestBody {
}
