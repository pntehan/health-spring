package org.example.healthspring.entity;

import java.util.Date;

public class RecordEntity {
    private int id;

    private int student_id;

    private Date exam_time;

    private float score;

    private String teacher_comment;

    private String warning_info;

    public RecordEntity() {
    }

    public RecordEntity(int student_id, Date exam_time, float score, String teacher_comment, String warning_info) {
        this.student_id = student_id;
        this.exam_time = exam_time;
        this.score = score;
        this.teacher_comment = teacher_comment;
        this.warning_info = warning_info;
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

    public Date getExam_time() {
        return exam_time;
    }

    public void setExam_time(Date exam_time) {
        this.exam_time = exam_time;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getTeacher_comment() {
        return teacher_comment;
    }

    public void setTeacher_comment(String teacher_comment) {
        this.teacher_comment = teacher_comment;
    }

    public String getWarning_info() {
        return warning_info;
    }

    public void setWarning_info(String warning_info) {
        this.warning_info = warning_info;
    }
}
