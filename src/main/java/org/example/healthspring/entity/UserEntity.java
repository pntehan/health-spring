package org.example.healthspring.entity;

public class UserEntity {
    private int id;

    private String name;

    private String password;

    private String gender;

    private String intro;

    private String role;

    private String status;

    private int classroom;

    public UserEntity() {}

    public UserEntity(int id, String name, String password, String gender, String intro, String role, String status, int classroom) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.intro = intro;
        this.role = role;
        this.status = status;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }
}
