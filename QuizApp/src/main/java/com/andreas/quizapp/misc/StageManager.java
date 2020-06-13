package main.java.com.andreas.quizapp.misc;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class StageManager {
    private static Stage stage;
    public static String screen;

    public StageManager(Stage stage) {
        this.stage = stage;
    }

    public static Stage getStage() { return stage; }
    public static void setRoot(Parent root) {
        StageManager.stage.getScene().setRoot(root);
    }
}
