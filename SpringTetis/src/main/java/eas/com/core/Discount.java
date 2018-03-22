package eas.com.core;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Discount {
    private Long id;

    private String name;

    private String expression;

    private boolean discountOverSingleProduct;

    public Discount(Long id, String name, String expression, boolean discountOverSingleProduct) {
        this.id = id;
        this.name = name;
        this.expression = expression;
        this.discountOverSingleProduct = discountOverSingleProduct;
    }

    void validate(StandardEvaluationContext evaluationContext, ExpressionParser parser, Context context) {
        Expression exp = parser.parseExpression(this.expression);
        if (this.discountOverSingleProduct) {
            validateSingle(evaluationContext, context, exp);
        } else {
            if (exp.getValue(evaluationContext, Boolean.class)) {
                System.out.println("El descuento: " + this.name + " se ha aplicado sobre la totalidad de los productos");
            } else {
                System.out.println("El descuento: " + this.name + " no se ha aplicado sobre la totalidad de los productos");
            }
        }
    }

    private void validateSingle(StandardEvaluationContext evaluationContext, Context context, Expression exp) {
        for (Product product : context.getProductList()) {
            evaluationContext.setVariable("pi", product);
            if (exp.getValue(evaluationContext, Boolean.class)) {
                System.out.println("El descuento: " + this.name + " se ha aplicado sobre el producto: " + product.getName());
            } else {
                System.out.println("El descuento: " + this.name + " no se ha aplicado sobre el producto: " + product.getName());
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean isDiscountOverSingleProduct() {
        return discountOverSingleProduct;
    }

    public void setDiscountOverSingleProduct(boolean discountOverSingleProduct) {
        this.discountOverSingleProduct = discountOverSingleProduct;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expression='" + expression + '\'' +
                ", discountOverSingleProduct=" + discountOverSingleProduct +
                '}';
    }
}
