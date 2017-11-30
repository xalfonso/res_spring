package eas.com;

import eas.com.core.Context;
import eas.com.core.Discount;
import eas.com.core.DiscountDetector;
import eas.com.core.Product;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*String test = "'Eduardo Alfonso Sanchez'.concat(' y Leydis Esther Garzon Giro').toUpperCase()";
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(test);
        String message = exp.getValue(String.class);

        System.out.println(message);*/

        //-----------------Context-----------------------
        Product product = new Product("Mantequilla", "Alimentos", 14.3f, 50);
        Product product1 = new Product("Pan", "Alimentos", 2.9f, 150);
        Product product2 = new Product("Lavadora", "Electrodomesticos", 300f, 10);

        List<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(product1);
        products.add(product2);

        Context context = new Context("Efectivo", "Frecuente", 190, products);

        //-----------------Discounts-----------------------
        Discount discountA = new Discount(1L, "Descuento A", "(#count(productList) >= 800 and paymentType == 'Efectivo') or clientType == 'Frecuente'", false);
        Discount discountB = new Discount(2L, "Descuento B", "(#pi.type == 'Electrodomesticos' or #pi.price > 14.00) and #pi.cant > 49", true);
        Discount discountC = new Discount(3L, "Descuento C", "#allMatch(productList, '#pf.price > 0.05') == true", false);


        Discount discountD = new Discount(4L, "Descuento D", "#anyMatchWithParams(productList, '#pf.name == #sa', {sa: 'Lavadora'}) == true", true);
        Discount discountE = new Discount(4L, "Descuento E", "#anyMatch(productList, '#pf.price >= 301') == true", true);
        Discount discountF = new Discount(5L, "Descuento F", "#countDistinct(productList) > 2 and #countDistinct(productList) < 5", false);
        Discount discountG = new Discount(7L, "Descuento G", "#countWithPredicate(productList, '#pf.cant == 150') >= 150", false);
        Discount discountH = new Discount(8L, "Descuento H", "#countWithPredicateAndParams(productList, '#pf.cant == 150 and #pf.type == #ty', {ty:'Electrodomesticos'}) >= 150", false);
        Discount discountI = new Discount(9L, "Descuento I", "#countDistinctWithPredicateAndParams(productList, '#pf.type == #ty', {ty:'Alimentos'}) == 2", false);
        Discount discountJ = new Discount(10L, "Descuento J", "#countDistinctWithPredicate(productList, '#pf.cant > 50 and #pf.cant < 300') == 2", false);


        List<Discount> discounts = new ArrayList<Discount>();
        discounts.add(discountA);
        discounts.add(discountB);
        discounts.add(discountC);
        discounts.add(discountD);
        discounts.add(discountE);
        discounts.add(discountF);
        discounts.add(discountG);
        discounts.add(discountH);
        discounts.add(discountI);
        discounts.add(discountJ);


        /**
         *
         * En vez de haber dos tipos de descuentos: discountOverSingleProduct true or false
         *
         * Deberian haber tres:
         * -Descuentos sobre productos : Esto ocaciona que se itere sobre cada producto y se compruebe una condición sobre ese producto o inluso una general pero el
         * descuento se ara sobre cada unos de los productos que cumplan esa condición sin importar la relación con otros productos (El descuento se aplica sobre el producto)
         * - Descuentos sobre productos teniendo en cuenta la relación con otros productos (El descuento se aplica sobre el producto)
         * - Descuentos sobre el total de los productos (El descuento se aplica sobre el total de los productos)
         *
         *
         *
         *
         *
         */

        //---------------------------
        DiscountDetector discountDetector = new DiscountDetector(context, discounts);
        try {
            discountDetector.parse();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
