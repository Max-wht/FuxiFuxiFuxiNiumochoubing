package tech.clac;

/**
 * @author Max
 * @description
 * @date 2025/6/21 13:46
 */
public class Main {
    public static void main(String[] args) {
        ExpressionParser expressionParser = new ExpressionParser("1+9");
        Expression parse = expressionParser.parse();
        System.out.println(parse.getValue());
    }
}
