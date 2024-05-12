package org.example.healthspring.entity;

public class CommentEntity {
    private int id;
    private int appointment_id;
    private int student_id;
    private int teacher_id;
    private String content;
    private int star;

    public CommentEntity() {};

    public CommentEntity(int appointment_id, int student_id, int teacher_id, String content, int star) {
        this.appointment_id = appointment_id;
        this.student_id = student_id;
        this.teacher_id = teacher_id;
        this.content = content;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
