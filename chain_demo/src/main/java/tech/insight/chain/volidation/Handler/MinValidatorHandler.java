package tech.insight.chain.volidation.Handler;

import tech.insight.chain.volidation.ValidatorContext;

/**
 * @author Max
 * @description
 * @date 2025/6/23 20:15
 */
public class MinValidatorHandler implements ValidatorHandler{
    private final int min;

    public MinValidatorHandler(int min) {
        this.min = min;
    }

    @Override
    public void validate(Object value, ValidatorContext context) {
        if (!(value instanceof Integer)) {
            context.appendError("The Min annotation's value is not Integer");
        }
        if ((Integer) value < min) {
            context.appendError("The value is smaller than the Min annotation's value");
        }
        context.doNext();
    }
}
