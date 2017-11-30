package eas.com.core;

public class Product {
    private String name;

    private String type;

    private float price;

    private int cant;

    public Product(String name, String type, float price, int cant) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.cant = cant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
