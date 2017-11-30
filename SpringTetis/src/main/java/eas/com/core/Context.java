package eas.com.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private final String paymentType;

    private final String clientType;

    private final int clientPoints;

    private final List<Product> productList;

    /**
     * Key. id of discount
     *   Key. child product
     *   Value. Parent product relate to discount
     */
    private Map<Long, Map<Long, Long>> discountProductGroups = new HashMap<Long, Map<Long, Long>>();


    public Context(String paymentType, String clientType, int clientPoints, List<Product> productList) {
        this.paymentType = paymentType;
        this.clientType = clientType;
        this.clientPoints = clientPoints;
        this.productList = productList;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getClientType() {
        return clientType;
    }

    public int getClientPoints() {
        return clientPoints;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Map<Long, Map<Long, Long>> getDiscountProductGroups() {
        return discountProductGroups;
    }

    public void setDiscountProductGroups(Map<Long, Map<Long, Long>> discountProductGroups) {
        this.discountProductGroups = discountProductGroups;
    }
}
