package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Currency  Converter");
        stage.setScene(loadScene(loadPane(), stage));
        stage.setResizable(false);
        stage.show();
    }

    private Pane loadPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResourceAsStream("/view/MainStage.fxml"));

    }

    private Scene loadScene(Pane pane, Stage stage) {
        Scene scene = new Scene(pane);
        scene.getStylesheets().setAll(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }

}