module main {
    requires javafx.controls;
    requires javafx.fxml;

    opens main to javafx.fxml;
    opens main.controller to javafx.fxml;
    exports main;
}
