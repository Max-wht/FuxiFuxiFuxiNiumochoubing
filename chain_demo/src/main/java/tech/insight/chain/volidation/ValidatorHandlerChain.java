package tech.insight.chain.volidation;

import tech.insight.chain.volidation.Handler.ValidatorHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max
 * @description
 * @date 2025/6/23 20:27
 */
public class ValidatorHandlerChain {

    private final List<ValidatorHandler> handlers = new ArrayList<ValidatorHandler>();
    private final ValidatorContext context = new ValidatorContext();
    private int index = 0;
    public void validate(Object obj){
        List<String> exceptions = new ArrayList<>();
        while (true) {
            index = context.getCurrentIndex();
            if (index == handlers.size())
                break;
            ValidatorHandler handler = handlers.get(index);
            handler.validate(obj, context);
            if (context.getCurrentIndex() == index)
                break;
        }
        context.throwEeceptionIfNecessary();
    }

    public void addLastHandler(ValidatorHandler handler) {
        this.handlers.add(handler);
    }
}
