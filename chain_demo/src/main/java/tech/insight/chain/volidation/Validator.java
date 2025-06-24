package tech.insight.chain.volidation;

import tech.insight.chain.ValidatorV2Exception;
import tech.insight.chain.annotation.Length;
import tech.insight.chain.annotation.Max;
import tech.insight.chain.annotation.Min;
import tech.insight.chain.volidation.Handler.LengthValidatorHandler;
import tech.insight.chain.volidation.Handler.MaxValidatorHandler;
import tech.insight.chain.volidation.Handler.MinValidatorHandler;

import java.lang.reflect.Field;

/**
 * @author Max
 * @description
 * @date 2025/6/23 20:09
 */
public class Validator {

    public void validate(Object obj) throws ValidatorV2Exception, IllegalAccessException {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            ValidatorHandlerChain chain = buildValidatorChain(field);
            chain.validate(field.get(obj));
        }
    }

    private ValidatorHandlerChain buildValidatorChain(Field  field) {
        ValidatorHandlerChain chain = new ValidatorHandlerChain();
        Min min = field.getAnnotation(Min.class);
        if(min != null) {
            chain.addLastHandler(new MinValidatorHandler(min.value()));
        }
        Max max = field.getAnnotation(Max.class);
        if(max != null) {
            chain.addLastHandler(new MaxValidatorHandler(max.value()));
        }
        Length length = field.getAnnotation(Length.class);
        if(length != null) {
            chain.addLastHandler(new LengthValidatorHandler(length.value()));
        }
        return chain;
    }

    private void validateLength(Length length, Object o) {

    }

    private void validateMin(Min min, Object o) {
    }

    private void validateMax(Max max, Object o) {

    }
}
