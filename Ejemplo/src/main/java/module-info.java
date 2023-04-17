module com.mycompany.ejemplo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ejemplo to javafx.fxml;
    exports com.mycompany.ejemplo;
}
