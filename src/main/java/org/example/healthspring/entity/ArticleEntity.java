package org.example.healthspring.entity;

import java.util.Date;

public class ArticleEntity {
    private int id;
    private String title;
    private String content;
    private byte[] cover; // longblob类型可以使用byte[]来表示
    private Date up_time;
    public ArticleEntity() {
    }

    public ArticleEntity(String title, String content, byte[] cover, Date up_time) {
        this.title = title;
        this.content = content;
        this.cover = cover;
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

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public Date getUp_time() {
        return up_time;
    }

    public void setUp_time(Date up_time) {
        this.up_time = up_time;
    }
}
