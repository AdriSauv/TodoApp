package adsa.fr.planning;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private ListView<String> taskListView;
    private TextField taskInputField;

    @Override
    public void start(Stage stage) throws IOException {
        // Initialize UI components
        taskListView = new ListView<>();
        taskInputField = new TextField();
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        // set event handler
        addButton.setOnAction((e -> addTask()));
        deleteButton.setOnAction((e -> deleteTask()));

        // Layout setup
        VBox root = new VBox();
        root.getChildren().addAll(taskInputField, addButton, deleteButton, taskListView);

        // Scene setup
        Scene scene = new Scene(root, 640, 480);

        // Stage setup
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.show();
    }

    private void addTask() {
        String task = taskInputField.getText();
        if (!task.isEmpty()){
            taskListView.getItems().add(task);
            taskInputField.clear();
        }
    }

    private void deleteTask() {
        int index = taskListView.getSelectionModel().getSelectedIndex();
        if (index >= 0){
            taskListView.getItems().remove(index);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}