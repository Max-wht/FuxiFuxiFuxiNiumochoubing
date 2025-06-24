package tech.clac;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * @author Max
 * @description
 * @date 2025/6/21 13:59
 */
public class ExpressionParser {

    private final String infixExpression;//中缀表达式
    int point = 0;

    public ExpressionParser(String infixExpression) {
        this.infixExpression = infixExpression;
    }

    public List<String> toSuffix() {
        List<String> suffix = new ArrayList<>();
        LinkedList<String> stack = new LinkedList<>();

        while (point < infixExpression.length()) {
            char c = infixExpression.charAt(point);
            if (c == '('){
                stack.addLast(c + "");
            } else if (c == ')') {
                while (stack.getLast() .equals('('+"")) {
                    suffix.add(stack.removeLast());
                }
                stack.removeLast();
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty() && stack.getLast().equals("*") || stack.getLast().equals("/")) {
                    suffix.add(stack.removeLast());
                }
                stack.addLast(c+"");
            } else if (c == '+' || c == '-') {
                while (topIsOperator(stack)) {
                    suffix.add(stack.removeLast());
                }
                stack.addLast(c+"");
            } else if (Character.isDigit( c)) {
                StringBuilder sb = new StringBuilder();
                while(point < infixExpression.length() && Character.isDigit(infixExpression.charAt(point))) {
                    sb.append(infixExpression.charAt(point));
                    point++;
                }
                point--;
                suffix.add(sb.toString());
            } else {
                throw new RuntimeException("Invalid Expression");
            }
            point ++;
        }
        while (!stack.isEmpty()) {
            suffix.add(stack.removeLast());
        }
        return suffix;
    }

    private boolean topIsOperator(LinkedList<String> stack) {
        if (stack.isEmpty()) {
            return false;
        }
        return Set.of("+", "-", "*", "/").contains(stack.getLast());
    }

    public Expression parse() {
        List<String> suffix = this.toSuffix();
        LinkedList<Expression> stack = new LinkedList<>();
        for (String token : suffix) {
            if (token.equals("+")) {
                Expression right = stack.removeLast();
                stack.addLast(new AddExpression(stack.removeLast(), right));
            } else if (token.equals("-")) {
                Expression right = stack.removeLast();
                stack.addLast(new SubstractExpression(stack.removeLast(), right));
            } else if (token.equals("*")) {
                Expression right = stack.removeLast();
                stack.addLast(new MulitplyExpression(stack.removeLast(), right));
            } else if (token.equals("/")) {
                Expression right = stack.removeLast();
                stack.addLast(new DevisionExpression(stack.removeLast(), right));
            } else {
                int i = Integer.parseInt(token);
                stack.addLast(new NumberExpression(i));
            }
        }
        return stack.removeLast();
    }
}

