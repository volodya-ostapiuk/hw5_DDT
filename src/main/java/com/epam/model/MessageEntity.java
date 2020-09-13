package com.epam.model;

public class MessageEntity {
    private String topic;

    private String receiver;

    private String cc;

    private String bcc;

    private String letterText;

    public MessageEntity(String topic, String receiver, String cc, String bcc, String letterText) {
        this.topic = topic;
        this.receiver = receiver;
        this.cc = cc;
        this.bcc = bcc;
        this.letterText = letterText;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getLetterText() {
        return letterText;
    }

    public void setLetterText(String letterText) {
        this.letterText = letterText;
    }
}
