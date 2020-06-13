package main.java.com.andreas.quizapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.java.com.andreas.quizapp.database.ConnectDB;
import main.java.com.andreas.quizapp.misc.StageManager;
import main.java.com.andreas.quizapp.misc.ThemeManager;


public class Main extends Application {
    public static final String APP_NAME = "QuizApp";

    @Override
    public void start(Stage primaryStage) throws Exception {
        new ConnectDB();

        StageManager.screen = "home";
        Parent homeWindow = FXMLLoader.load(getClass().getResource("../../../../resources/fxml/HomeWindow.fxml"));
        Stage homeStage = new Stage();
        ThemeManager.setTheme(homeWindow);

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        homeStage.setWidth(screenBounds.getWidth() * 0.60);
        homeStage.setHeight(screenBounds.getHeight() * 0.70);
        homeStage.setMinWidth(400.0);
        homeStage.setMinHeight(745.0);

        homeStage.getIcons().add(new Image(getClass().getResource("../../../../resources/assets/icon.png").toExternalForm()));
        homeStage.setScene(new Scene(homeWindow));
        homeStage.setTitle(APP_NAME);
        homeStage.show();
        new StageManager(homeStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
