package com.epam.model;

import java.util.List;

public class GmailJsonEntity {
    private MessageEntity message;

    private List<UserEntity> users;

    public GmailJsonEntity() {
    }

    public GmailJsonEntity(MessageEntity message, List<UserEntity> users) {
        this.message = message;
        this.users = users;
    }

    public MessageEntity getMessage() {
        return message;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
