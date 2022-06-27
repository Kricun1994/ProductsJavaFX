package org.maksimov.repository;


import org.maksimov.model.Product;
import org.maksimov.utill.RandomNumberGenerator;

import java.util.Arrays;

public class SaleTransaction {
    private Product[] items;
    private int saleCode;
    private double totalCost;
    private int index;

    public SaleTransaction() {
        RandomNumberGenerator saleCodeRandom = new RandomNumberGenerator(1000, 9999);
        this.items = new Product[3];
        saleCode = saleCodeRandom.randomGenerator();
    }

    public Product[] getItems() {
        return Arrays.copyOf(this.items, index);
    }

    public boolean addProductToBasket(Product product) {
        if (this.index == this.items.length) {
            return false;
        }
        this.items[this.index] = product;
        this.index++;
        this.totalCost += product.getPrice() * product.getMinOrderQty();
        return true;
    }

    public boolean remove(int item) {
        if (item >= 0 && item < this.index) {
            Product item1 = this.items[item];
            this.totalCost -= item1.getPrice() * item1.getMinOrderQty();
            for (int i = item; i < index - 1; i++) {
                this.items[i] = this.items[i + 1];
            }
            this.index--;
            return true;
        }
        return false;
    }

    public int getCount() {
        return this.index;
    }

    public Product getItem(int i) {
        if (i < 0 || i >= index) {
            return null;
        }
        return this.items[i];
    }

    public void makeTransaction() {
        for (int i = 0; i < this.index; i++) {
            Product item = this.items[i];
            item.setQtyOnHnd(item.getQtyOnHnd() - item.getMinOrderQty());
        }
        this.items = new Product[3];
        this.index = 0;
        this.totalCost = 0;
    }

    public String toString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < this.index; i++) {
            stringBuilder.append("\n");
            stringBuilder.append("Выберите продукт: ").append(i + 1);
            stringBuilder.append("\n");
            stringBuilder.append(this.items[i]);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

  /*  public int getCountProduct(ProductList productList, Product product) {
        int countProd = 0;
        for (int i = 0; i < index; i++) {
            if (getItem(i).equals(product)) {
                countProd++;
            }
        }
        return countProd;
    }*/

}
