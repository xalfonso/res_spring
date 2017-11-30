package eas.com;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Main {
    public static void main(String[] args) {
        String test = "'Eduardo Alfonso Sanchez'.concat(' y Leydis Esther Garzon Giro').toUpperCase()";
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(test);
        String message = exp.getValue(String.class);

        System.out.println(message);
    }
}
