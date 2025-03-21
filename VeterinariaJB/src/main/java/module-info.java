module com.example.veterinariajb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires java.logging;


    opens com.example.veterinariajb to javafx.fxml;
    exports com.example.veterinariajb;
}