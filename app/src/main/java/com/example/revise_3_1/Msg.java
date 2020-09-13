package com.example.revise_3_1;

public class Msg {
    public static final int TYPE_SEND = 0;
    public static final int TYPE_RECEIVED = 1;
    private int content;
    private String message;

    public Msg(int content, String message) {
        this.content = content;
        this.message = message;
    }

    public int getContent() {
        return content;
    }

    public String getMessage() {
        return message;
    }
}
