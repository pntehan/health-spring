package org.example.healthspring.entity;

import java.util.Date;

public class ExamEntity {
    private int id;

    private String question;

    public ExamEntity() {
    }

    public ExamEntity(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
