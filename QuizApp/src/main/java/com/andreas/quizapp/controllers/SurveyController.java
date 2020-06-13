package main.java.com.andreas.quizapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.java.com.andreas.quizapp.database.QuestionsDB;
import main.java.com.andreas.quizapp.misc.StageManager;
import main.java.com.andreas.quizapp.misc.ThemeManager;
import main.java.com.andreas.quizapp.misc.Transitions;
import main.java.com.andreas.quizapp.model.Question;

import java.io.IOException;
import java.util.List;

public class SurveyController {
    @FXML
    private VBox questionBox;
    @FXML
    private Label headerText;
    @FXML
    private ImageView catImage;
    @FXML
    private Label questionText;
    @FXML
    private Text questionNumber;
    private ToggleGroup response;
    @FXML
    private ToggleButton responseA;
    @FXML
    private ToggleButton responseB;
    @FXML
    private ToggleButton responseC;
    @FXML
    private ToggleButton responseD;
    @FXML
    private Button nextButton;
    @FXML
    private Label textResponseA;
    @FXML
    private Label textResponseB;
    @FXML
    private Label textResponseC;
    @FXML
    private Label textResponseD;
    private List<Question> questions;
    private int currentQuestion = 1;
    private int score = 0;
    private char answerQ1, answerQ2, answerQ3, answerQ4, answerQ5, answerQ6, answerQ7, answerQ8, answerQ9, answerQ10;
    @FXML
    private VBox resultBox;
    @FXML
    private Text scoreText;

    public void initialize() {
        resultBox.setVisible(false);
        resultBox.setManaged(false);
        switch (StageManager.screen) {
            case "literature":
                headerText.setText("Art and Literature");
                catImage.setImage(new Image(getClass().getResource("../../../../../resources/assets/literature.png").toExternalForm()));
                questions = QuestionsDB.getRandomQuestions("Art and Literature");
                break;
            case "geography":
                headerText.setText("Geography");
                catImage.setImage(new Image(getClass().getResource("../../../../../resources/assets/geography.png").toExternalForm()));
                questions = QuestionsDB.getRandomQuestions("Geography");
                break;
            case "generalknowledge":
                headerText.setText("General Knowledge");
                catImage.setImage(new Image(getClass().getResource("../../../../../resources/assets/generalknow.png").toExternalForm()));
                questions = QuestionsDB.getRandomQuestions("General Knowledge");
                break;
            case "history":
                headerText.setText("History");
                catImage.setImage(new Image(getClass().getResource("../../../../../resources/assets/history.png").toExternalForm()));
                questions = QuestionsDB.getRandomQuestions("History");
                break;
            case "math":
                headerText.setText("Mathematics");
                catImage.setImage(new Image(getClass().getResource("../../../../../resources/assets/math.png").toExternalForm()));
                questions = QuestionsDB.getRandomQuestions("Mathematics");
                break;
            case "science":
                headerText.setText("Science & Nature");
                catImage.setImage(new Image(getClass().getResource("../../../../../resources/assets/science.png").toExternalForm()));
                questions = QuestionsDB.getRandomQuestions("Science and Nature");
                break;
        }

        response = new ToggleGroup();
        responseA.setToggleGroup(response);
        responseB.setToggleGroup(response);
        responseC.setToggleGroup(response);
        responseD.setToggleGroup(response);

        responseA.setOnAction(e -> {
            if (responseA.isSelected()) nextButton.setDisable(false);
            else nextButton.setDisable(true);
        });
        responseB.setOnAction(e -> {
            if (responseB.isSelected()) nextButton.setDisable(false);
            else nextButton.setDisable(true);
        });
        responseC.setOnAction(e -> {
            if (responseC.isSelected()) nextButton.setDisable(false);
            else nextButton.setDisable(true);
        });
        responseD.setOnAction(e -> {
            if (responseD.isSelected()) nextButton.setDisable(false);
            else nextButton.setDisable(true);
        });

        loadQuestion();
    }

    public void loadQuestion() {
        Transitions.fadeInPanel(questionBox);
        nextButton.setDisable(true);
        responseA.setSelected(false);
        responseB.setSelected(false);
        responseC.setSelected(false);
        responseD.setSelected(false);
        questionNumber.setText(String.valueOf(currentQuestion));
        questionText.setText(questions.get(currentQuestion-1).getText());
        textResponseA.setText(questions.get(currentQuestion-1).getResponseA());
        textResponseB.setText(questions.get(currentQuestion-1).getResponseB());
        textResponseC.setText(questions.get(currentQuestion-1).getResponseC());
        textResponseD.setText(questions.get(currentQuestion-1).getResponseD());
    }

    public char getResponse() {
        if (responseA.isSelected()) return 'A';
        if (responseB.isSelected()) return 'B';
        if (responseC.isSelected()) return 'C';
        if (responseD.isSelected()) return 'D';
        return 0;
    }

    @FXML
    public void nextPage() {
        switch (currentQuestion) {
            case 1:
                answerQ1 = getResponse();
                if (answerQ1 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 2:
                answerQ2 = getResponse();
                if (answerQ2 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 3:
                answerQ3 = getResponse();
                if (answerQ3 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 4:
                answerQ4 = getResponse();
                if (answerQ4 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 5:
                answerQ5 = getResponse();
                if (answerQ5 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 6:
                answerQ6 = getResponse();
                if (answerQ6 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 7:
                answerQ7 = getResponse();
                if (answerQ7 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 8:
                answerQ8 = getResponse();
                if (answerQ8 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 9:
                answerQ9 = getResponse();
                if (answerQ9 == questions.get(currentQuestion-1).getAnswer()) score++;
                break;
            case 10:
                answerQ10 = getResponse();
                if (answerQ10 == questions.get(currentQuestion-1).getAnswer()) score++;
                scoreText.setText(score*10 + "% Score");
                if (score >= 7) scoreText.setFill(Color.web("#30BE6C"));
                else if (score >=5) scoreText.setFill(Color.web("#FF8C00"));
                else scoreText.setFill(Color.web("#dd4b39"));
                questionBox.setVisible(false);
                questionBox.setManaged(false);
                resultBox.setVisible(true);
                resultBox.setManaged(true);
                Transitions.fadeInPanel(resultBox);
                break;
        }
        currentQuestion++;
        if (currentQuestion <= 10) loadQuestion();
    }

    @FXML
    public void closeScreen() {
        try {
            StageManager.screen = "home";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../../resources/fxml/HomeWindow.fxml"));
            Parent survey = loader.load();
            ThemeManager.setTheme(survey);
            StageManager.setRoot(survey);
        } catch (IOException e) {
            System.out.println("Could not add home window file.");
        }
    }
}
