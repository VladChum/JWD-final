package com.epam.jwd_final.entity;

public class Question {
    private String question;
    private String answer;
    private User user;
    private Support support;

    public Question(String question, String answer, User user, Support support) {
        this.question = question;
        this.answer = answer;
        this.user = user;
        this.support = support;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
