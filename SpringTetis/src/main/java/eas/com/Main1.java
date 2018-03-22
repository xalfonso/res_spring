package eas.com;

import eas.com.core.Discount;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        /*Set<Map.Entry<Object,Object>> pro = System.getProperties().entrySet();

        for (Map.Entry<Object, Object> objectObjectEntry : pro) {
            System.out.println(objectObjectEntry.getKey() + " : " + objectObjectEntry.getValue());
        }*/

        Discount discount = new Discount(5L, "Eduardi", "Expresion 1", true);
        Discount discount1 = new Discount(5L, "Leydis", "Expresion 1", true);

        System.out.println("Mostrando Descuento");
        System.out.println(discount);


        System.out.println("Mostrando Descuento 1");
        System.out.println(discount1);

        discount.setName(discount1.getName());

        System.out.println("Mostrando Descuento despues del primer seteo");
        System.out.println(discount);


        System.out.println("Mostrando Descuento 1 despues del primer seteo");
        System.out.println(discount1);

        discount1.setName(null);

        System.out.println("Mostrando Descuento despues del segundo seteo");
        System.out.println(discount);


        System.out.println("Mostrando Descuento 1 despues del segundo seteo");
        System.out.println(discount1);


    }
}
