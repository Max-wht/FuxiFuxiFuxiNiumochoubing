package tech.insight.chain.volidation.Handler;

import tech.insight.chain.volidation.ValidatorContext;

/**
 * @author Max
 * @description
 * @date 2025/6/23 20:15
 */
public class MaxValidatorHandler implements ValidatorHandler{

    private final int max;

    public MaxValidatorHandler(int max) {
        this.max = max;
    }

    @Override
    public void validate(Object obj, ValidatorContext context) {
        if (!(obj instanceof Integer)) {
            context.appendError("The Max annotation's value is not Integer");
        }
        if ((Integer) obj > max) {
            context.appendError("The value is greater than the Max annotation's value");
//            context.stopChain();
        }
        context.doNext();
    }
}
