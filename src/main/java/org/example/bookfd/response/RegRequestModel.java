package org.example.bookfd.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegRequestModel {
    private int status_operation;
    private int id;
    private String info;
    private Boolean use_app_late;
    private String access_token;
    private String refresh_token;
    private int sms;

    public RegRequestModel(int status_operation, int sms, String info, Boolean use_app_late) {
        this.status_operation = status_operation;
        this.info = info;
        this.use_app_late = use_app_late;
        this.sms = sms;
    }

    public RegRequestModel(int status_operation, String info, Boolean use_app_late) {
        this.status_operation = status_operation;
        this.info = info;
        this.use_app_late = use_app_late;
    }

    public RegRequestModel(int status_operation, int id, String info, Boolean use_app_late, String access_token, String refresh_token) {
        this.status_operation = status_operation;
        this.id = id;
        this.info = info;
        this.use_app_late = use_app_late;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
    }
}
