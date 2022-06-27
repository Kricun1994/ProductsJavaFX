module org.maksimov {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens org.maksimov to javafx.fxml;
    exports org.maksimov;
    exports org.maksimov.model to com.fasterxml.jackson.databind;
}
