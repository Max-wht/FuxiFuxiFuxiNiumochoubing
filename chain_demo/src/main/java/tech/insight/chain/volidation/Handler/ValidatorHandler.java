package tech.insight.chain.volidation.Handler;

import tech.insight.chain.volidation.ValidatorContext;

/**
 * @author Max
 * @description
 * @date 2025/6/23 20:14
 */
public interface ValidatorHandler {
    void validate(Object obj, ValidatorContext context);
}
