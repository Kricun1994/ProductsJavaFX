package org.maksimov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.maksimov.model.Product;
import org.maksimov.repository.ProductList;

public class RegisterProductController {
    private ProductList productList;

    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldDesc;
    @FXML
    private TextField textFieldPrice;

    public void RegisterProduct(ActionEvent actionEvent) {
        String name = this.textFieldName.getText();
        String desc = this.textFieldDesc.getText();
        String price = this.textFieldPrice.getText();

        if (name.isEmpty()) {
            App.showAlert("ERROR", "Name is empty", Alert.AlertType.ERROR);
            return;
        }
        if (desc.isEmpty()) {
            App.showAlert("ERROR", "Desc is empty", Alert.AlertType.ERROR);
            return;
        }
        if (price.isEmpty()) {
            App.showAlert("ERROR", "Price is empty", Alert.AlertType.ERROR);
            return;
        }
        try {
            double priceD = Double.parseDouble(price);
            this.productList.addProduct(new Product(name, desc, priceD));
            App.showAlert("Info", "Product added!", Alert.AlertType.INFORMATION);

            Stage stage = (Stage) textFieldPrice.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            App.showAlert("ERROR", "Price is not number", Alert.AlertType.ERROR);
        }

    }


    public void setData(ProductList productList) {
        this.productList = productList;
    }
}
