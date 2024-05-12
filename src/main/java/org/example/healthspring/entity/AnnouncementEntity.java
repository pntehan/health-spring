package org.example.healthspring.entity;

import java.util.Date;

public class AnnouncementEntity {
    private int id;
    private String title;
    private String content;
    private Date up_time;

    public AnnouncementEntity() {};

    public AnnouncementEntity(String title, String content, Date up_time) {
        this.title = title;
        this.content = content;
        this.up_time = up_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUp_time() {
        return up_time;
    }

    public void setUp_time(Date up_time) {
        this.up_time = up_time;
    }
}
