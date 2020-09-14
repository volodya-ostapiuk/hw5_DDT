package com.epam.model;

public class UserEntity {
    private String email;

    private String password;

    private boolean expected;

    public UserEntity() {
    }

    public UserEntity(String email, String password, boolean expected) {
        this.email = email;
        this.password = password;
        this.expected = expected;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isExpected() {
        return expected;
    }

    public void setExpected(boolean expected) {
        this.expected = expected;
    }
}
