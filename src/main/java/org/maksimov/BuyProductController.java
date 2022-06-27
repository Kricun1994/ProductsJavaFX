package org.maksimov;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import org.maksimov.model.Product;
import org.maksimov.repository.ProductList;
import org.maksimov.repository.SaleTransaction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BuyProductController {
    @FXML
    public ComboBox<Product> comboBoxProducts;
    @FXML
    public ListView<Product> listOfProducts;
    SaleTransaction saleTransaction;
    ProductList productList;

    public void initialize() {

    }

    public void AddProduct(ActionEvent actionEvent) {
        Product selectedItem = this.comboBoxProducts.getSelectionModel().getSelectedItem();
        if (selectedItem.getQtyOnHnd() < selectedItem.getMinOrderQty() * this.saleTransaction.getCount()) {
            App.showAlert("ERROR", "Не хватает зарегистрированного товара", Alert.AlertType.ERROR);
            return;
        }

        if (selectedItem.getMinOrderQty() > selectedItem.getQtyOnHnd()) {
            App.showAlert("ERROR", "Количество зарегистрированного товара меньше," +
                    " чем необходимо для минимального заказа", Alert.AlertType.ERROR);
            return;
        }
        this.saleTransaction.addProductToBasket(selectedItem);
        App.showAlert("INFORMATION", "Товар добавлен в корзину", Alert.AlertType.INFORMATION);

        this.listOfProducts.setItems(FXCollections.observableList(Arrays.asList(saleTransaction.getItems())));
    }


    public void setData(ProductList productList, SaleTransaction saleTransaction) {
        this.saleTransaction = saleTransaction;
        this.productList = productList;
        this.comboBoxProducts.setItems(FXCollections.observableList(Arrays.asList(productList.getListOfProducts())));
        this.listOfProducts.setItems(FXCollections.observableList(Arrays.asList(saleTransaction.getItems())));
    }

    public void saveToFile(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"));

        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            this.productList.toFile(file.getAbsolutePath());
        }
    }
}
