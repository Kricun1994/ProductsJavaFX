package org.maksimov.repository;


import org.maksimov.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ProductList {
    private Product[] listOfProducts;
    private int index;

    public ProductList() {
        this.listOfProducts = new Product[5];
    }

    public Product[] getListOfProducts() {

        return Arrays.copyOf(this.listOfProducts, index);
    }

    public boolean addProduct(Product product) {
        if (this.index == this.listOfProducts.length)
            return false;
        this.listOfProducts[index] = product;
        this.index++;
        return true;
    }

    public int getCount() {
        return index;
    }

    public Product getProduct(int i) {
        if (i < 0 || i >= this.listOfProducts.length) {
            return null;
        }
        return this.listOfProducts[i];
    }

    public void writeToCSV(String filename) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, StandardCharsets.UTF_8))) {
            StringBuilder stringBuilder = new StringBuilder("name;desc;price;qtyOnHnd;minOrderQty");
            stringBuilder.append("\n");
            for (int i = 0; i < index; i++) {
                stringBuilder.append(this.listOfProducts[i].toCSV());
                stringBuilder.append("\n");
            }
            bufferedWriter.append(stringBuilder);
        }
    }

    public void writeToJson(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product[] products = new Product[this.index];
        for (int i = 0; i < index; i++) {
            products[i] = this.listOfProducts[i];
        }
        objectMapper.writeValue(new File(filename), products);

    }


    public void toFile(String file) throws IOException {
        if (file.endsWith(".csv")) {
            writeToCSV(file);
        } else if (file.endsWith(".json")) {
            writeToJson(file);
        } else {
            throw new IllegalArgumentException("Неверный формат");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Список доступных к заказу товаров: ");
        for (int i = 0; i < this.index; i++) {
            stringBuilder.append("\n");
            stringBuilder.append("Выберите продукт").append(": ").append(i + 1);
            stringBuilder.append("\n");
            stringBuilder.append(this.listOfProducts[i]);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


}
