package tech.insight.chain.volidation;

import tech.insight.chain.ValidatorV2Exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Max
 * @description
 * @date 2025/6/23 21:02
 */
public class ValidatorContext {
    private final List<String> errorMessages = new ArrayList<>();
    private boolean stop = false;
    private int currentIndex = 0;
    public void appendError(String message) {
        errorMessages.add( message);
    }
    public void throwEeceptionIfNecessary() {
        if (!errorMessages.isEmpty()) {
            throw new ValidatorV2Exception(errorMessages.toString());
        }
    }
    public void stopChain() {
        this.stop = true;
    }
    public boolean shouldStop() {
        return stop;
    }
    public void doNext() {
        currentIndex++;
    }
    public int getCurrentIndex() {
        return currentIndex;
    }
}
