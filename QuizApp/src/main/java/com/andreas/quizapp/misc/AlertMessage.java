package main.java.com.andreas.quizapp.misc;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class AlertMessage {

    public AlertMessage(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type,content);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.showAndWait();
    }
}
