package org.maksimov.model;


import org.maksimov.utill.RandomNumberGenerator;

import java.util.Locale;
import java.util.Objects;

public class Product {
    private String name;
    private String desc;
    private double price;
    private int qtyOnHnd;
    private int minOrderQty;

    public Product() {
    }

    public Product(String name, String desc, double price) {
        RandomNumberGenerator qtyOnHndGenerator = new RandomNumberGenerator(0, 10);
        RandomNumberGenerator minOrderQtyGenerator = new RandomNumberGenerator(1, 5);
        this.name = name.toLowerCase(Locale.ROOT);
        this.desc = desc;
        this.price = price;
        this.qtyOnHnd = qtyOnHndGenerator.randomGenerator();
        this.minOrderQty = minOrderQtyGenerator.randomGenerator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyOnHnd() {
        return qtyOnHnd;
    }

    public void setQtyOnHnd(int qtyOnHnd) {
        this.qtyOnHnd = qtyOnHnd;
    }

    public int getMinOrderQty() {
        return minOrderQty;
    }

    public void setMinOrderQty(int minOrderQty) {
        this.minOrderQty = minOrderQty;
    }

    // переписать в строку
    public void productInfo() {
        System.out.println("Название" + ": " + this.getName());
        System.out.println("Описание товара" + ": " + this.getDesc());
        System.out.println("Количество" + ": " + this.getQtyOnHnd());
        System.out.println("Цена" + ": " + this.getPrice());
        System.out.println("Минимальное количество заказа" + ": " + this.getMinOrderQty());
    }

    public String toCSV() {
        return this.name + ';' + this.desc + ';' +
                this.price + ';' + this.qtyOnHnd + ';' + this.minOrderQty + ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && qtyOnHnd == product.qtyOnHnd &&
                minOrderQty == product.minOrderQty && Objects.equals(name, product.name) && Objects.equals(desc, product.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, price, qtyOnHnd, minOrderQty);
    }

    @Override
    public String toString() {
        return "Название:" + this.name + "\n" + "Описание товара: " + this.getDesc() + "\n" + "Количество: "
                + this.getQtyOnHnd() + "\n" + "Цена: " + this.getPrice() + "\n"
                + "Минимальное количество заказа: " + this.getMinOrderQty();
    }
}
