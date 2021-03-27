package com.fzu.meetsystem.pojo;

public class Meeting {

    private int id;
    private String name;
    private int chairmanId;
    private int secretaryId;
    private String content;

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

    public int getChairmanId() {
        return chairmanId;
    }

    public void setChairmanId(int chairmanId) {
        this.chairmanId = chairmanId;
    }

    public int getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(int secretaryId) {
        this.secretaryId = secretaryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
