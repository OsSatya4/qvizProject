package org.nye.qvizmainproject.database;

import org.nye.qvizmainproject.model.Profile;
import org.nye.qvizmainproject.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseManager {

    // Kérdések lekérése kategória alapján (GameEngine-nek)
    public List<Question> getQuestionsByCategory(String categoryName) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT q.*, c.name AS cat_name FROM questions q " +
                "JOIN categories c ON q.category_id = c.id WHERE c.name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoryName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                List<String> answers = Arrays.asList(
                        rs.getString("answer_a"),
                        rs.getString("answer_b"),
                        rs.getString("answer_c"),
                        rs.getString("answer_d")
                );
                questions.add(new Question(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("cat_name"),
                        rs.getString("question_text"),
                        answers,
                        rs.getInt("correct_index")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    // Új kérdés beszúrása (AdminController-nek)
    public void insertQuestion(int categoryId, String text, List<String> answers, int correctIndex) {
        String sql = "INSERT INTO questions (category_id, question_text, answer_a, answer_b, answer_c, answer_d, correct_index) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, categoryId);
            stmt.setString(2, text);
            stmt.setString(3, answers.get(0));
            stmt.setString(4, answers.get(1));
            stmt.setString(5, answers.get(2));
            stmt.setString(6, answers.get(3));
            stmt.setInt(7, correctIndex);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Kérdés törlése ID alapján (AdminController-nek)
    public void deleteQuestionById(int id) {
        String sql = "DELETE FROM questions WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Új kategória létrehozása (AdminController-nek)
    public void insertCategory(String name) {
        String sql = "INSERT INTO categories (name) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Összes kategória neve (Adminnak és főmenünek)
    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT name FROM categories";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categories.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}