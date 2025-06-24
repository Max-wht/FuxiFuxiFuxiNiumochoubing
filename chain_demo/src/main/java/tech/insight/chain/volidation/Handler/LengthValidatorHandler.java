package tech.insight.chain.volidation.Handler;

import tech.insight.chain.volidation.ValidatorContext;

/**
 * @author Max
 * @description
 * @date 2025/6/23 20:15
 */
public class LengthValidatorHandler implements ValidatorHandler{

    private final int length;

    public LengthValidatorHandler(int length) {
        this.length = length;
    }

    @Override
    public void validate(Object value, ValidatorContext context) {
        if (!(value instanceof String)) {
            context.appendError("The Length annotation's value is not Integer");
        }
        if (((String)value).length() != length) {
            context.appendError("The value is not equal to the Length annotation's value");
        }
        context.doNext();
    }
}
