package tech.clac;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:48
 */
public abstract class BinaryOperatorExpression implements Expression{

    Expression left;
    Expression right;

    protected BinaryOperatorExpression(Expression left , Expression right) {
        this.left = left;
        this.right = right;
    }
}
