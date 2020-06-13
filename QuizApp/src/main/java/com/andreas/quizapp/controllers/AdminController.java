package main.java.com.andreas.quizapp.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.java.com.andreas.quizapp.database.QuestionsDB;
import main.java.com.andreas.quizapp.misc.*;
import main.java.com.andreas.quizapp.model.Question;
import org.bson.Document;

import java.io.IOException;

public class AdminController {

    @FXML
    private StackPane homeWindowSP;
    @FXML
    private VBox addMenu;
    @FXML
    private VBox editMenu;
    @FXML
    private VBox deleteMenu;
    @FXML
    private FlowPane optionsPane;
    @FXML
    private ComboBox ComboCategory;
    @FXML
    private ComboBox ComboAnswer;
    @FXML
    private TextArea FieldQnText;
    @FXML
    private TextField FieldRespA;
    @FXML
    private TextField FieldRespB;
    @FXML
    private TextField FieldRespC;
    @FXML
    private TextField FieldRespD;
    private final char [] ans = {'A', 'B', 'C', 'D'};
    @FXML
    private ComboBox ComboCategoryDel;
    @FXML
    private ComboBox ComboQuestions;
    @FXML
    private ComboBox ComboCategoryEdit;
    @FXML
    private ComboBox ComboQuestionsEdit;
    @FXML
    private ComboBox ComboCatEdit;
    @FXML
    private ComboBox ComboAnswerEdit;
    @FXML
    private TextArea FieldQnTextEdit;
    @FXML
    private TextField FieldRespAEdit;
    @FXML
    private TextField FieldRespBEdit;
    @FXML
    private TextField FieldRespCEdit;
    @FXML
    private TextField FieldRespDEdit;

    public void initialize() {
        homeWindowSP.getChildren().removeAll(addMenu, editMenu, deleteMenu);
        Transitions.fadeInPanel(optionsPane);
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

    @FXML
    public void addPane() {
        homeWindowSP.getChildren().remove(optionsPane);
        homeWindowSP.getChildren().add(addMenu);
        Transitions.fadeInPanel(addMenu);
        FieldQnText.setText("");
        FieldRespA.setText("");
        FieldRespB.setText("");
        FieldRespC.setText("");
        FieldRespD.setText("");
        ComboCategory.getItems().clear();
        ComboCategory.getItems().addAll(Categories.list);
        ComboCategory.setValue("Art and Literature");
        ComboAnswer.getItems().clear();
        ComboAnswer.getItems().addAll("Answer A", "Answer B", "Answer C", "Answer D");
        ComboAnswer.setValue("Answer A");
    }

    @FXML
    public void editPane() {
        homeWindowSP.getChildren().remove(optionsPane);
        homeWindowSP.getChildren().add(editMenu);
        Transitions.fadeInPanel(editMenu);
        FieldQnTextEdit.setText("");
        FieldRespAEdit.setText("");
        FieldRespBEdit.setText("");
        FieldRespCEdit.setText("");
        FieldRespDEdit.setText("");
        ComboCategoryEdit.getItems().clear();
        ComboCategoryEdit.getItems().addAll(Categories.list);
        ComboCategoryEdit.setValue("");
        ComboQuestionsEdit.getItems().clear();
        ComboQuestionsEdit.setValue("");
        ComboCategoryEdit.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                ComboQuestionsEdit.getItems().clear();
                ComboQuestionsEdit.setValue("");
                if (t1 != null && !QuestionsDB.getQuestions(t1).isEmpty()) {
                    ComboQuestionsEdit.getItems().addAll(QuestionsDB.getQuestions(ComboCategoryEdit.getSelectionModel().getSelectedItem().toString()));
                    ComboQuestionsEdit.setValue("");
                }
            }
        });
        ComboCatEdit.getItems().clear();
        ComboCatEdit.setValue("");
        ComboAnswerEdit.getItems().clear();
        ComboAnswerEdit.setValue("");
        ComboQuestionsEdit.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                ComboCatEdit.getItems().clear();
                ComboCatEdit.setValue("");
                ComboAnswerEdit.getItems().clear();
                ComboAnswerEdit.setValue("");
                if (t1 != null) {
                    Question qn = QuestionsDB.getQuestion(ComboCategoryEdit.getSelectionModel().getSelectedItem().toString(), t1);
                    ComboCatEdit.getItems().addAll(Categories.list);
                    ComboCatEdit.setValue(qn.getCategory());
                    ComboAnswerEdit.getItems().addAll("Answer A", "Answer B", "Answer C", "Answer D");
                    ComboAnswerEdit.setValue("Answer " + qn.getAnswer());
                    FieldQnTextEdit.setText(qn.getText());
                    FieldRespAEdit.setText(qn.getResponseA());
                    FieldRespBEdit.setText(qn.getResponseB());
                    FieldRespCEdit.setText(qn.getResponseC());
                    FieldRespDEdit.setText(qn.getResponseD());
                }
            }
        });
    }

    @FXML
    public void deletePane() {
        homeWindowSP.getChildren().remove(optionsPane);
        homeWindowSP.getChildren().add(deleteMenu);
        Transitions.fadeInPanel(deleteMenu);
        ComboCategoryDel.getItems().clear();
        ComboCategoryDel.getItems().addAll(Categories.list);
        ComboCategoryDel.setValue("");
        ComboQuestions.getItems().clear();
        ComboQuestions.setValue("");
        ComboCategoryDel.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                ComboQuestions.getItems().clear();
                ComboQuestions.setValue("");
                if (t1 != null && !QuestionsDB.getQuestions(t1).isEmpty()) {
                    ComboQuestions.getItems().addAll(QuestionsDB.getQuestions(ComboCategoryDel.getSelectionModel().getSelectedItem().toString()));
                    ComboQuestions.setValue("");
                }
            }
        });

    }

    @FXML
    public void cancel() {
        homeWindowSP.getChildren().removeAll(addMenu, editMenu, deleteMenu);
        homeWindowSP.getChildren().add(optionsPane);
        Transitions.fadeInPanel(optionsPane);
    }

    @FXML
    public void save() {
        if (FieldQnText.getText().isEmpty() || FieldRespA.getText().isEmpty() || FieldRespB.getText().isEmpty() || FieldRespC.getText().isEmpty() || FieldRespD.getText().isEmpty()) {
            new AlertMessage("Warning", "All fields are mandatory.", Alert.AlertType.WARNING);
        } else {
            if (QuestionsDB.addQuestion(new Document("category", ComboCategory.getSelectionModel().getSelectedItem().toString()).append("text", FieldQnText.getText())
                    .append("responseA", FieldRespA.getText()).append("responseB", FieldRespB.getText()).append("responseC", FieldRespC.getText()).append("responseD", FieldRespD.getText()).append("answer", ans[ComboAnswer.getSelectionModel().getSelectedIndex()]))) {
                new AlertMessage("Success!", "The question was added successfully.", Alert.AlertType.INFORMATION);
            } else {
                new AlertMessage("Error!", "Please try again.", Alert.AlertType.ERROR);
            }
            clearSave();
        }
    }

    public void clearSave() {
        ComboCategory.setValue("Art and Literature");
        ComboAnswer.setValue("Answer A");
        FieldQnText.setText("");
        FieldRespA.setText("");
        FieldRespB.setText("");
        FieldRespC.setText("");
        FieldRespD.setText("");
    }

    @FXML
    public void delete() {
        if (ComboCategoryDel.getSelectionModel().getSelectedItem().toString().isEmpty() || ComboQuestions.getSelectionModel().getSelectedItem().toString().isEmpty()) {
            new AlertMessage("Warning", "All fields are mandatory.", Alert.AlertType.WARNING);
        } else {
            if (QuestionsDB.deleteQuestion(new Document("category", ComboCategoryDel.getSelectionModel().getSelectedItem().toString()).append("text", ComboQuestions.getSelectionModel().getSelectedItem().toString()))) {
                new AlertMessage("Success!", "The question was deleted successfully.", Alert.AlertType.INFORMATION);
            } else {
                new AlertMessage("Error!", "Please try again.", Alert.AlertType.ERROR);
            }
            clearDelete();
        }
    }

    public void clearDelete() {
        ComboCategoryDel.setValue("");
        ComboQuestions.getItems().clear();
    }

    @FXML
    public void edit() {
        if (ComboCategoryEdit.getSelectionModel().getSelectedItem().toString().isEmpty() || ComboQuestionsEdit.getSelectionModel().getSelectedItem().toString().isEmpty() ||
                ComboCatEdit.getSelectionModel().getSelectedItem().toString().isEmpty() || ComboAnswerEdit.getSelectionModel().getSelectedItem().toString().isEmpty() ||
                FieldQnTextEdit.getText().isEmpty() || FieldRespAEdit.getText().isEmpty() || FieldRespBEdit.getText().isEmpty() || FieldRespCEdit.getText().isEmpty() || FieldRespDEdit.getText().isEmpty()) {
            new AlertMessage("Warning", "All fields are mandatory.", Alert.AlertType.WARNING);
        } else {
            if (QuestionsDB.editQuestion(new Document("category", ComboCategoryEdit.getSelectionModel().getSelectedItem().toString()).append("text", ComboQuestionsEdit.getSelectionModel().getSelectedItem().toString()),
            new Document("category", ComboCatEdit.getSelectionModel().getSelectedItem().toString()).append("text", FieldQnTextEdit.getText())
                    .append("responseA", FieldRespAEdit.getText()).append("responseB", FieldRespBEdit.getText()).append("responseC", FieldRespCEdit.getText()).append("responseD", FieldRespDEdit.getText())
                    .append("answer", ans[ComboAnswerEdit.getSelectionModel().getSelectedIndex()]))) {
                new AlertMessage("Success!", "The question was edited successfully.", Alert.AlertType.INFORMATION);
            } else {
                new AlertMessage("Error!", "Please try again.", Alert.AlertType.ERROR);
            }
            clearEdit();
        }
    }

    public void clearEdit() {
        ComboCategoryEdit.setValue("");
        ComboQuestionsEdit.getItems().clear();
        ComboCatEdit.getItems().clear();
        ComboAnswerEdit.getItems().clear();
        FieldQnTextEdit.setText("");
        FieldRespAEdit.setText("");
        FieldRespBEdit.setText("");
        FieldRespCEdit.setText("");
        FieldRespDEdit.setText("");
    }

}
