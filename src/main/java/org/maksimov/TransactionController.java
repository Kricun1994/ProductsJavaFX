package org.maksimov;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.maksimov.model.Product;
import org.maksimov.repository.SaleTransaction;

import java.util.Arrays;

public class TransactionController {
    @FXML
    public ListView<Product> listOfProducts;
    SaleTransaction saleTransaction;

    public void buttonTransaction(ActionEvent actionEvent) {
        if (this.saleTransaction.getCount() == 0) {
            App.showAlert("ERROR", "Корзина пуста", Alert.AlertType.ERROR);
            return;
        }
        this.saleTransaction.makeTransaction();
        App.showAlert("INFORMATION", "Транзакция проведена успешно", Alert.AlertType.INFORMATION);
        this.saleTransaction = new SaleTransaction();
        this.listOfProducts.setItems(FXCollections.observableList(Arrays.asList(this.saleTransaction.getItems())));
        Stage stage = (Stage) listOfProducts.getScene().getWindow();
        stage.close();

    }

    public void setData(SaleTransaction saleTransaction) {
        this.saleTransaction = saleTransaction;
        this.listOfProducts.setItems(FXCollections.observableList(Arrays.asList(this.saleTransaction.getItems())));

    }
}
