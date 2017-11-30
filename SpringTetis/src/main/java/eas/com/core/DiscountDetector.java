package eas.com.core;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
import java.util.Map;

public class DiscountDetector {

    private Context context;

    private List<Discount> discountList;

    public DiscountDetector(Context context, List<Discount> discountList) {
        this.context = context;
        this.discountList = discountList;
    }

    public void parse() throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext(this.context);
        registerOperators(evaluationContext);

        for (Discount discount : discountList) {
            discount.validate(evaluationContext, parser, context);
        }
    }

    public void showResult() {
        System.out.println(this.context.getDiscountProductGroups().toString());
    }

    private void registerOperators(StandardEvaluationContext evaluationContext) throws NoSuchMethodException {
        evaluationContext.registerFunction("allMatch",
                CustomOperators.class.getDeclaredMethod("allMatch",List.class, String.class));

        evaluationContext.registerFunction("anyMatch",
                CustomOperators.class.getDeclaredMethod("anyMatch",List.class, String.class));

        evaluationContext.registerFunction("anyMatchWithParams",
                CustomOperators.class.getDeclaredMethod("anyMatch",List.class, String.class, Map.class));

        evaluationContext.registerFunction("count",
                CustomOperators.class.getDeclaredMethod("count", List.class));

        evaluationContext.registerFunction("countWithPredicate",
                CustomOperators.class.getDeclaredMethod("count", List.class, String.class));

        evaluationContext.registerFunction("countWithPredicateAndParams",
                CustomOperators.class.getDeclaredMethod("count", List.class, String.class, Map.class));

        evaluationContext.registerFunction("countDistinct",
                CustomOperators.class.getDeclaredMethod("countDistinct", List.class));

        evaluationContext.registerFunction("countDistinctWithPredicate",
                CustomOperators.class.getDeclaredMethod("countDistinct", List.class, String.class));

        evaluationContext.registerFunction("countDistinctWithPredicateAndParams",
                CustomOperators.class.getDeclaredMethod("countDistinct", List.class, String.class, Map.class));



    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
    }
}
