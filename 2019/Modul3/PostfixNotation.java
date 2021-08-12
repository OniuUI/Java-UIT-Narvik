package Modul3;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class PostfixNotation {
    private ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    StringTokenizer tokens;
    int result;

    private void scanAndProcessTokens() {
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if (token.length() == 0)
                continue;
            if (token.matches("(.)*(\\d)(.)*")) {
                arrayDeque.push(Integer.parseInt(token));
            } else if (token.matches("[+-/*%]")) {
                calculateExpression(token);
            }
        }
    }

    public void calculateExpression(String token) {
        int var1 = arrayDeque.pop(), var2 = arrayDeque.pop();
        switch (token) {
            case "-": {
                result = var2 - var1;
                arrayDeque.push(result);
            }
            break;
            case "+": {
                result = var2 + var1;
                arrayDeque.push(result);
            }
            break;
            case "/": {
                result = var2 / var1;
                arrayDeque.push(result);
            }
            break;
            case "*": {
                result = var2 * var1;
                arrayDeque.push(result);
            }
            break;
            case "%": {
                result = var2 % var1;
                arrayDeque.push(result);
            }
            break;
        }
    }

    public int evaluateExpression(String expression) {
        if (expression == null) {
            throw new NullPointerException("Expression Cannot be Null.");
        }
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Empty Stack.");
        }
        if (expression.trim().length() > 0 && !expression.trim().matches(".*\\d.*")) {
            throw new NoSuchElementException("No Elements in Stack.");
        }
        if (expression.trim().contains("0/")) {
            throw new ArithmeticException("/ by zero");
        }
        tokens = new StringTokenizer(expression, " +-/*%", true);
        scanAndProcessTokens();
        return result;

    }
}
