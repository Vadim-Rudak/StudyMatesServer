package org.example.bookfd.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Results {

    @Id
    private int id;
    private int idtest;
    private String username;
    private int score;
    private int num_correct_otv;
    private int num_error_otv;
    private int num_no_otv;

    public Results() {
    }

    public Results(int id, int idtest, String username, int score, int num_correct_otv, int num_error_otv, int num_no_otv) {
        this.id = id;
        this.idtest = idtest;
        this.username = username;
        this.score = score;
        this.num_correct_otv = num_correct_otv;
        this.num_error_otv = num_error_otv;
        this.num_no_otv = num_no_otv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdtest() {
        return idtest;
    }

    public void setIdtest(int idtest) {
        this.idtest = idtest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNum_correct_otv() {
        return num_correct_otv;
    }

    public void setNum_correct_otv(int num_correct_otv) {
        this.num_correct_otv = num_correct_otv;
    }

    public int getNum_error_otv() {
        return num_error_otv;
    }

    public void setNum_error_otv(int num_error_otv) {
        this.num_error_otv = num_error_otv;
    }

    public int getNum_no_otv() {
        return num_no_otv;
    }

    public void setNum_no_otv(int num_no_otv) {
        this.num_no_otv = num_no_otv;
    }
}
