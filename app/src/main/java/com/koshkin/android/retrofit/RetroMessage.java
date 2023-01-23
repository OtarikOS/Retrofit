package com.koshkin.android.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroMessage {
    @SerializedName("id")
    private Integer id;
    @SerializedName("time")
    Long time;
    @SerializedName("text")
    private String text;


    public RetroMessage(Integer id, Long time, String text) {
        super();
        this.id = id;
        this.time = time;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
