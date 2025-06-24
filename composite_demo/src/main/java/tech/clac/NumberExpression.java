package tech.clac;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:47
 */
public class NumberExpression implements Expression{

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int getValue() {
        return number;
    }
}
