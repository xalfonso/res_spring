package eas.com.core;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * En muchas ocaciones se van a ejecutar un metodo muchas veces sobre los mismos datos, lo que se puede hacer una especie de cache para evitar ejecutar el metodo nuevamente.
 */
public class CustomOperators {

    private static StandardEvaluationContext standardEvaluationContextProduct = new StandardEvaluationContext();
    private static ExpressionParser parser = new SpelExpressionParser();

    //public static boolean allMatch(List<Product> productList, String predicate, Product productToExclude, Long amountToFind, Map<Long, Long> discountGroup) {

    /**
     * @param productList
     * @param predicate
     * @return true if all product match with the predicate, false otherwise
     */
    public static boolean allMatch(List<Product> productList, String predicate) {
        Objects.requireNonNull(productList);
        Objects.requireNonNull(predicate);
        boolean result = true;
        Expression exp = parser.parseExpression(predicate);

        for (Product product : productList) {
            standardEvaluationContextProduct.setVariable("pf", product);
            if (!exp.getValue(standardEvaluationContextProduct, Boolean.class)) {
                result = false;
            }
        }

        return result;
    }

    /**
     * @param productList
     * @param predicate
     * @param params      for evaluate in the expression
     * @return true if at least any product match with the predicate, false otherwise
     */
    public static boolean anyMatch(List<Product> productList, String predicate, Map<String, Object> params) {
        Objects.requireNonNull(productList);
        Objects.requireNonNull(predicate);
        boolean result = false;
        Expression exp = parser.parseExpression(predicate);

        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                standardEvaluationContextProduct.setVariable(entry.getKey(), entry.getValue());
            }
        }

        for (Product product : productList) {
            standardEvaluationContextProduct.setVariable("pf", product);
            if (exp.getValue(standardEvaluationContextProduct, Boolean.class)) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * @param productList
     * @param predicate
     * @return true if at least any product match with the predicate, false otherwise
     */
    public static boolean anyMatch(List<Product> productList, String predicate) {
        return anyMatch(productList, predicate, null);
    }

    /**
     * @param productList
     * @return the total amount of the products
     */
    public static int count(List<Product> productList) {
        int cant = 0;
        for (Product product : productList) {
            cant += product.getCant();
        }

        System.out.println("count result: " + cant);
        return cant;
    }

    /**
     * @param productList
     * @param predicate
     * @param params      for evaluate the predicate
     * @return the total amount of the products that match with the predicate
     */
    public static int count(List<Product> productList, String predicate, Map<String, Object> params) {
        Objects.requireNonNull(productList);
        Expression exp = parser.parseExpression(predicate);

        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                standardEvaluationContextProduct.setVariable(entry.getKey(), entry.getValue());
            }
        }
        int cant = 0;

        for (Product product : productList) {
            standardEvaluationContextProduct.setVariable("pf", product);
            if (exp.getValue(standardEvaluationContextProduct, Boolean.class)) {
                cant += product.getCant();
            }
        }

        System.out.println("count result with predicate: " + cant);
        return cant;
    }

    /**
     * @param productList
     * @param predicate
     * @return the total amount of the products that match with the predicate
     */
    public static int count(List<Product> productList, String predicate) {
        return count(productList, predicate, null);
    }

    /**
     * @param productList
     * @return the amount of the different products, the size of the list
     */
    public static int countDistinct(List<Product> productList) {
        System.out.println("count distinct result: " + productList.size());
        return productList.size();
    }

    /**
     * @param productList
     * @param predicate
     * @param params
     * @return the amount of the different products that match with the predicate, the size of the list
     */
    public static int countDistinct(List<Product> productList, String predicate, Map<String, Object> params) {
        Objects.requireNonNull(productList);
        Expression exp = parser.parseExpression(predicate);

        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                standardEvaluationContextProduct.setVariable(entry.getKey(), entry.getValue());
            }
        }
        int cant = 0;

        for (Product product : productList) {
            standardEvaluationContextProduct.setVariable("pf", product);
            if (exp.getValue(standardEvaluationContextProduct, Boolean.class)) {
                cant++;
            }
        }

        System.out.println("count distinct result with predicate: " + cant);
        return cant;
    }

    /**
     * @param productList
     * @param predicate
     * @return the amount of the different products that match with the predicate, the size of the list
     */
    public static int countDistinct(List<Product> productList, String predicate) {
        return countDistinct(productList, predicate, null);
    }


}
