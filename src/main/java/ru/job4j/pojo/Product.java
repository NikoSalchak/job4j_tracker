package ru.job4j.pojo;

public class Product {
    private String nameProduct;
    private int count;

    public Product(String name, int count) {
        this.nameProduct = name;
        this.count = count;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String name) {
        this.nameProduct = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
