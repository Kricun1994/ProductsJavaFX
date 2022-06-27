package org.maksimov.utill;



import org.maksimov.model.Product;

import java.util.Objects;

public class Methods {
    public static boolean isDigit(String stringNumber) {
        for (int i = 0; i < stringNumber.length(); i++) {
            if (!Character.isDigit(stringNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNull(Product[] products) {
        for (Product product : products) {
            if (!Objects.isNull(product)) {
                return true;
            }
        }
        return false;
    }

    public static int arrayFullness(Product[] products) {
        int counter = 0;
        for (int i = 0; i < products.length; i++) {
            if (!Objects.isNull(products[i])) {
                counter++;
            }
        }
        return counter;

    }
}
