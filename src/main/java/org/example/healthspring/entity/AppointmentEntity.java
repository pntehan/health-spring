package org.example.healthspring.entity;

import java.util.Date;

public class AppointmentEntity {
    private int id;
    private int student_id;
    private String student_name;
    private int teacher_id;
    private String teacher_name;
    private Date up_time;
    private String status;

    public AppointmentEntity() {};

    public AppointmentEntity(int student_id, int teacher_id, Date up_time, String status) {
        this.student_id = student_id;
        this.teacher_id = teacher_id;
        this.up_time = up_time;
        this.status = status;
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

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
