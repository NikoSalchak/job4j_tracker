package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (Product product : products) {
            System.out.println(product.getNameProduct());
        }
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getNameProduct());
            } else {
                System.out.println("null");
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Bread 1", 4);
        products[1] = new Product("Egg 2", 10);
        products[2] = new Product("Milk 3", 2);
        products[3] = new Product("Fish 4", 3);
        products[4] = new Product("Fruit 5", 8);
        delete(products, 2);
    }
}
