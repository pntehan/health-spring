package org.example.healthspring.entity;

import java.util.Date;

public class StarEntity {
    private int id;
    private int student_id;
    private int article_id;
    private int teacher_id;
    private Date up_time;

    public StarEntity() {};

    public StarEntity(int student_id, int article_id, int teacher_id, Date up_time) {
        this.student_id = student_id;
        this.article_id = article_id;
        this.teacher_id = teacher_id;
        this.up_time = up_time;
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

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
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
}
