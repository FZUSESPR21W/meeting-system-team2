package com.fzu.meetsystem.pojo;

public class Meeting {

    private Integer id;
    private String name;
    private Integer chairmanId;
    private Integer secretaryId;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChairmanId() {
        return chairmanId;
    }

    public void setChairmanId(Integer chairmanId) {
        this.chairmanId = chairmanId;
    }

    public Integer getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(Integer secretaryId) {
        this.secretaryId = secretaryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
