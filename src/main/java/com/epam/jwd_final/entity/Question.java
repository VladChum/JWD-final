package com.epam.jwd_final.entity;

import java.util.Objects;

public class Question extends AbstractBaseEntity {
    private String question;
    private String answer;
    private Long userId;
    private Long supportId;

    public Question(Long id, String question, String answer, Long userId, Long supportId) {
        super(id);
        this.question = question;
        this.answer = answer;
        this.userId = userId;
        this.supportId = supportId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSupportId() {
        return supportId;
    }

    public void setSupportId(Long supportId) {
        this.supportId = supportId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer, userId, supportId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Question question = (Question) obj;
        return Objects.equals(this.question, question.question)
                && Objects.equals(answer, question.answer)
                && Objects.equals(userId, question.userId)
                && Objects.equals(supportId,question.supportId);
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", userId=" + userId +
                ", supportId=" + supportId +
                '}';
    }
}
