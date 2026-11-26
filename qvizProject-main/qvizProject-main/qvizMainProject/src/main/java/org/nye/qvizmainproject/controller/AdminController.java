package org.nye.qvizmainproject.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.nye.qvizmainproject.database.DatabaseManager;
import org.nye.qvizmainproject.model.Question;

import java.util.Arrays;
import java.util.List;

public class AdminController {
    private final DatabaseManager dbManager = new DatabaseManager();

    @FXML private TextField categoryField;
    @FXML private TextField categoryIdField;
    @FXML private TextField questionField;
    @FXML private TextField ansAField;
    @FXML private TextField ansBField;
    @FXML private TextField ansCField;
    @FXML private TextField ansDField;
    @FXML private TextField correctIndexField;
    @FXML private TextField deleteIdField;
    @FXML private Label statusLabel;

    @FXML
    private void handleAddCategory() {
        String name = categoryField.getText().trim();
        if (!name.isEmpty()) {
            updateCategory(name);
            categoryField.clear();
            statusLabel.setText("Kategória sikeresen hozzáadva: " + name);
        }
    }

    @FXML
    private void handleAddQuestion() {
        try {
            int catId = Integer.parseInt(categoryIdField.getText().trim());
            int correctIdx = Integer.parseInt(correctIndexField.getText().trim());
            List<String> answers = Arrays.asList(
                    ansAField.getText(), ansBField.getText(), ansCField.getText(), ansDField.getText()
            );

            Question q = new Question(0, catId, "", questionField.getText(), answers, correctIdx);
            addQuestion(q);

            questionField.clear();
            ansAField.clear(); ansBField.clear(); ansCField.clear(); ansDField.clear();
            statusLabel.setText("Kérdés sikeresen elmentve az adatbázisba!");
        } catch (NumberFormatException e) {
            statusLabel.setText("Hiba: A kategória ID és a helyes válasz indexe szám legyen!");
        }
    }

    @FXML
    private void handleDeleteQuestion() {
        try {
            int id = Integer.parseInt(deleteIdField.getText().trim());
            deleteQuestion(id);
            deleteIdField.clear();
            statusLabel.setText("Kérdés törölve (ID: " + id + ")");
        } catch (NumberFormatException e) {
            statusLabel.setText("Hiba: Érvényes számot adj meg ID-ként!");
        }
    }

    // Az UML szerinti metódusok
    public void addQuestion(Question q) {
        dbManager.insertQuestion(q.getCategoryId(), q.getQuestionText(), q.getAnswers(), q.getCorrectIndex());
    }

    public void deleteQuestion(int id) {
        dbManager.deleteQuestionById(id);
    }

    public void updateCategory(String name) {
        dbManager.insertCategory(name);
    }
}