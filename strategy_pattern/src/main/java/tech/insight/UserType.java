package tech.insight;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author Max
 * @description
 * @date 2025/6/22 22:32
 */
public enum UserType {
    NORMAL(recharge -> recharge > 0 && recharge <=100),
    SMALL(recharge -> recharge > 100 && recharge <= 1000),
    BIG(recharge -> recharge > 1000 && recharge <= 10000),
    SUPER(recharge -> recharge > 10000);

    private final IntPredicate support;

    UserType (IntPredicate support) {
        this.support = support;
    }

    public static UserType matches(int recharge) {
        for (UserType value : values()) {
            if (value.support.test(recharge)) {
                return value;
            }
        }
        return null;
    }
}

