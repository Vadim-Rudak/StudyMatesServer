package org.example.bookfd.domain;

public class Reg {

    private String message;
    private Boolean status_reg;

    public Reg() {
    }

    public Reg(String message, Boolean status_reg) {
        this.message = message;
        this.status_reg = status_reg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus_reg() {
        return status_reg;
    }

    public void setStatus_reg(Boolean status_reg) {
        this.status_reg = status_reg;
    }
}
