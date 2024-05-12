package org.example.healthspring.entity;

import java.util.Date;

public class ConsultEntity {
    private int id;
    private int student_id;
    private int teacher_id;
    private Date up_time;
    private String status;
    private String question;
    private String answer;

    public ConsultEntity() {};

    public ConsultEntity(int student_id, Date up_time, String status, String question, String answer) {
        this.student_id = student_id;
        this.up_time = up_time;
        this.status = status;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Date getUp_time() {
        return up_time;
    }

    public void setUp_time(Date up_time) {
        this.up_time = up_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
