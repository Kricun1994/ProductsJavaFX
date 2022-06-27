package org.maksimov;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.maksimov.model.Product;
import org.maksimov.repository.SaleTransaction;
import java.util.ArrayList;
import java.util.Objects;

public class ShowProductsController {
    @FXML
    public ListView<Product> listOfProducts;
    SaleTransaction saleTransaction;

    public void setData(SaleTransaction saleTransaction) {

        this.saleTransaction = saleTransaction;
        if (this.saleTransaction.getCount() == 0) {
            App.showAlert("ERROR", "Корзина пуста", Alert.AlertType.ERROR);
            return;
        }
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < this.saleTransaction.getItems().length; i++) {
            if (!Objects.isNull(this.saleTransaction.getItems()[i])) {
                products.add(this.saleTransaction.getItems()[i]);
            }
        }
        if (products.size() == 0) {
            App.showAlert("ERROR", "Корзина пуста", Alert.AlertType.ERROR);
            return;
        }
        this.listOfProducts.setItems(FXCollections.observableList(products));
    }
}
