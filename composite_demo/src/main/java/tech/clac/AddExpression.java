package tech.clac;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:50
 */
public class AddExpression extends BinaryOperatorExpression{

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }
    @Override
    public int getValue() {
        return left.getValue() + right.getValue();
    }
}
