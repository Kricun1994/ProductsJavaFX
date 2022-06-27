package org.maksimov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.maksimov.model.Product;
import org.maksimov.repository.ProductList;
import org.maksimov.repository.SaleTransaction;

import java.io.IOException;

public class MainController {
    private ProductList productList;
    private SaleTransaction saleTransaction;

    @FXML
    public void initialize() {
        this.productList = new ProductList();
        this.saleTransaction = new SaleTransaction();
    }

    public void buttonRegistration(ActionEvent actionEvent) throws IOException {
        if (this.productList.getCount() == 5) {
            App.showAlert("ERROR", "Продуктовый список заполнен", Alert.AlertType.ERROR);
            return;
        }
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "register_product.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        RegisterProductController controller = loader.getController();
        controller.setData(this.productList);
        stage.show();
    }

    public void buttonBuyProduct(ActionEvent actionEvent) throws IOException {
        if (this.productList.getCount() == 0) {
            App.showAlert("ERROR", "Не зарегистрированно ни одного товара", Alert.AlertType.ERROR);
            return;
        }
        if (this.saleTransaction.getCount() == 3) {
            App.showAlert("ERROR", "корзина заполнена", Alert.AlertType.ERROR);
            return;
        }
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "buy_product.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        BuyProductController controller = loader.getController();
        controller.setData(this.productList, this.saleTransaction);
        stage.show();
    }

    public void buttonDeleteProduct(ActionEvent actionEvent) throws IOException {
        if (this.saleTransaction.getCount() == 0) {
            App.showAlert("ERROR", "Корзина пуста", Alert.AlertType.ERROR);
            return;
        }
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "deleteProduct.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        DeleteProductController controller = loader.getController();
        controller.setData(this.saleTransaction);
        stage.show();


    }

    public void buttonShowProduct(ActionEvent actionEvent) throws IOException {
        if (this.saleTransaction.getCount() == 0) {
            App.showAlert("ERROR", "Корзина пуста", Alert.AlertType.ERROR);
            return;
        }
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "show_products.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        ShowProductsController controller = loader.getController();
        controller.setData(this.saleTransaction);
        stage.show();
    }

    public void buttonMakeTransaction(ActionEvent actionEvent) throws IOException {
        if (this.saleTransaction.getCount() == 0) {
            App.showAlert("ERROR", "Корзина пуста", Alert.AlertType.ERROR);
            return;
        }
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "transaction.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(loader.load())
        );

        TransactionController controller = loader.getController();
        controller.setData(this.saleTransaction);
        stage.show();

    }


    //код открытия новой формы и передача туда product List


}
