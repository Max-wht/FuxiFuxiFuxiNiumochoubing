package tech.insight.ExecutorHandlerPolicy;

import java.util.concurrent.RejectedExecutionException;

/**
 * @author Max
 * @description
 * @date 2025/6/24 15:27
 */
public class AbortPolicy implements ExecutorHandlerPolicy{

    @Override
    public void handle() {
        throw new RejectedExecutionException("Abort");
    }
}
