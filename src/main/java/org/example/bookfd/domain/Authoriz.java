package org.example.bookfd.domain;

public class Authoriz {

    private String name_user;
    private Boolean status;
    private String message;
    private String role;

    public Authoriz(String name_user, Boolean status, String message, String role) {
        this.name_user = name_user;
        this.status = status;
        this.message = message;
        this.role = role;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
