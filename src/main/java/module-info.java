module adsa.fr.planning {
    requires javafx.controls;
    requires javafx.fxml;


    opens adsa.fr.planning to javafx.fxml;
    exports adsa.fr.planning;
}