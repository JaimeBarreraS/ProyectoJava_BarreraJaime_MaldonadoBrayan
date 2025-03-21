module com.example.veterinariajb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.veterinariajb to javafx.fxml;
    exports com.example.veterinariajb;
}