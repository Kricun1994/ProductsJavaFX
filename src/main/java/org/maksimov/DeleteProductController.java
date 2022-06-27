package org.maksimov;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.maksimov.model.Product;
import org.maksimov.repository.SaleTransaction;

import java.util.Arrays;

public class DeleteProductController {

    @FXML
    public ListView<Product> listOfProduct;
    SaleTransaction saleTransaction;

    public void deleteProductButton(ActionEvent actionEvent) {
        int selectedIndex = this.listOfProduct.getSelectionModel().getSelectedIndex();
        this.saleTransaction.remove(selectedIndex);
        App.showAlert("INFORMATION", "Товар успешно удален", Alert.AlertType.INFORMATION);
        this.listOfProduct.setItems(FXCollections.observableList(Arrays.asList(this.saleTransaction.getItems())));
    }

    public void setData(SaleTransaction saleTransaction) {
        this.saleTransaction = saleTransaction;
        this.listOfProduct.setItems(FXCollections.observableList(Arrays.asList(this.saleTransaction.getItems())));
    }
}
