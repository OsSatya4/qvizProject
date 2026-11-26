package org.nye.qvizmainproject.model;

public class Profile {
    private String username;
    private String email;
    private String avatarPath;
    private int totalGamesPlayed;
    private int totalScore;

    public Profile() {
    }

    public Profile(String username, String email, String avatarPath, int totalGamesPlayed, int totalScore) {
        this.username = username;
        this.email = email;
        this.avatarPath = avatarPath;
        this.totalGamesPlayed = totalGamesPlayed;
        this.totalScore = totalScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", totalGamesPlayed=" + totalGamesPlayed +
                ", totalScore=" + totalScore +
                '}';
    }
}