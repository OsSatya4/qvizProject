package org.nye.qvizmainproject.model;

public class Settings {
    private String difficulty; // pl. "EASY", "MEDIUM", "HARD"
    private int numberOfQuestions;
    private double soundVolume; // 0.0 - 1.0 közötti érték
    private boolean darkModeEnabled;

    public Settings() {
        // Alapértelmezett beállítások
        this.difficulty = "MEDIUM";
        this.numberOfQuestions = 10;
        this.soundVolume = 0.8;
        this.darkModeEnabled = false;
    }

    public Settings(String difficulty, int numberOfQuestions, double soundVolume, boolean darkModeEnabled) {
        this.difficulty = difficulty;
        this.numberOfQuestions = numberOfQuestions;
        this.soundVolume = soundVolume;
        this.darkModeEnabled = darkModeEnabled;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public double getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(double soundVolume) {
        this.soundVolume = Math.max(0.0, Math.min(1.0, soundVolume));
    }

    public boolean isDarkModeEnabled() {
        return darkModeEnabled;
    }

    public void setDarkModeEnabled(boolean darkModeEnabled) {
        this.darkModeEnabled = darkModeEnabled;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "difficulty='" + difficulty + '\'' +
                ", numberOfQuestions=" + numberOfQuestions +
                ", soundVolume=" + soundVolume +
                ", darkModeEnabled=" + darkModeEnabled +
                '}';
    }
}