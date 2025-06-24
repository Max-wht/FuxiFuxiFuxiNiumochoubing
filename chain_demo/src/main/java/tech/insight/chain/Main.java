package tech.insight.chain;

import tech.insight.chain.volidation.Validator;

/**
 * @author Max
 * @description
 * @date 2025/6/23 20:33
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Tomw", 118);
        Validator validator = new Validator();
        validator.validate(user);
    }
}
