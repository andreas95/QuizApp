package main.java.com.andreas.quizapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import main.java.com.andreas.quizapp.database.QuestionsDB;
import main.java.com.andreas.quizapp.misc.AlertMessage;
import main.java.com.andreas.quizapp.misc.StageManager;
import main.java.com.andreas.quizapp.misc.ThemeManager;
import main.java.com.andreas.quizapp.misc.Transitions;

import java.io.IOException;
import java.util.Optional;

public class HomeWindowController {
    @FXML
    private Button buttonLiterature;
    @FXML
    private Button buttonGeography;
    @FXML
    private Button buttonGeneralKnow;
    @FXML
    private Button buttonHistory;
    @FXML
    private Button buttonMath;
    @FXML
    private Button buttonScience;
    @FXML
    private FlowPane categoriesPane;
    private final String adminPass = "123456";

    public void initialize() {
        Transitions.fadeInPanel(categoriesPane);
        buttonLiterature.setDisable(!QuestionsDB.existsCategory("Art and Literature"));
        buttonGeography.setDisable(!QuestionsDB.existsCategory("Geography"));
        buttonGeneralKnow.setDisable(!QuestionsDB.existsCategory("General Knowledge"));
        buttonHistory.setDisable(!QuestionsDB.existsCategory("History"));
        buttonMath.setDisable(!QuestionsDB.existsCategory("Mathematics"));
        buttonScience.setDisable(!QuestionsDB.existsCategory("Science and Nature"));
    }

    @FXML
    public void setLiterature(){
        try {
            StageManager.screen = "literature";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/fxml/Survey.fxml"));
            Parent survey = loader.load();
            ThemeManager.setTheme(survey);
            StageManager.setRoot(survey);
        } catch (IOException e) {
            System.out.println("Could not add survey file.");
        }
    }

    @FXML
    public void setGeography(){
        try {
            StageManager.screen = "geography";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/fxml/Survey.fxml"));
            Parent survey = loader.load();
            ThemeManager.setTheme(survey);
            StageManager.setRoot(survey);
        } catch (IOException e) {
            System.out.println("Could not add survey file.");
        }
    }

    @FXML
    public void setGeneralKnow(){
        try {
            StageManager.screen = "generalknowledge";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/fxml/Survey.fxml"));
            Parent survey = loader.load();
            ThemeManager.setTheme(survey);
            StageManager.setRoot(survey);
        } catch (IOException e) {
            System.out.println("Could not add survey file.");
        }
    }

    @FXML
    public void setHistory(){
        try {
            StageManager.screen = "history";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/fxml/Survey.fxml"));
            Parent survey = loader.load();
            ThemeManager.setTheme(survey);
            StageManager.setRoot(survey);
        } catch (IOException e) {
            System.out.println("Could not add survey file.");
        }
    }

    @FXML
    public void setMath(){
        try {
            StageManager.screen = "math";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/fxml/Survey.fxml"));
            Parent survey = loader.load();
            ThemeManager.setTheme(survey);
            StageManager.setRoot(survey);
        } catch (IOException e) {
            System.out.println("Could not add survey file.");
        }
    }

    @FXML
    public void setScience(){
        try {
            StageManager.screen = "science";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/fxml/Survey.fxml"));
            Parent survey = loader.load();
            ThemeManager.setTheme(survey);
            StageManager.setRoot(survey);
        } catch (IOException e) {
            System.out.println("Could not add survey file.");
        }
    }

    @FXML
    public void adminMenu() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.setGraphic(new ImageView(new Image(getClass().getResource("../../../../../resources/assets/login.png").toExternalForm())));
        dialog.setTitle("Admin access");
        dialog.setHeaderText("Admin access");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        HBox passBox = new HBox((7.0));
        passBox.setAlignment(Pos.BASELINE_CENTER);
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        passBox.getChildren().addAll(new Label("Please enter the password:"), password);
        dialog.getDialogPane().setContent(passBox);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && password.getText().equals(adminPass)) {
            try {
                StageManager.screen = "admin";
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/fxml/AdminWindow.fxml"));
                Parent survey = loader.load();
                ThemeManager.setTheme(survey);
                StageManager.setRoot(survey);
            } catch (IOException e) {
                System.out.println("Could not add survey file.");
            }
        } else if (result.isPresent() && result.get() == ButtonType.OK) {
            new AlertMessage("Error", "The password is incorrect.", Alert.AlertType.WARNING);
        }
}
}
