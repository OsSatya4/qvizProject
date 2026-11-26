package org.nye.qvizmainproject.model;

//Juhász Ferenc Dániel
public class Question {
    private int id;
    private String category;
    private String questionText;
    private List<String> answers;
    private int correctAnswerIndex;

    public boolean checkAnswer(int index) {
        return this.correctAnswerIndex == index;
    }

    public Question(int id, String category, String questionTest, List<String> answers, int correctAnswerIndex) {
        this.id = id;
        this.category = category;
        this.questionText = questionTest;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestionTest() {
        return questionText;
    }

    public void setQuestionTest(String questionTest) {
        this.questionText = questionTest;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
