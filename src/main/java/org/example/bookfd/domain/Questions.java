package org.example.bookfd.domain;

import javax.persistence.*;

@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int id;
    public String question;
    public String otv1;
    public String otv2;
    public String otv3;
    public String otv4;
    public String correctotv;
    public int testid;

    public Questions() {
    }

    public Questions(int id, String question, String otv1, String otv2, String otv3, String otv4, String correctotv, int testid) {
        this.id = id;
        this.question = question;
        this.otv1 = otv1;
        this.otv2 = otv2;
        this.otv3 = otv3;
        this.otv4 = otv4;
        this.correctotv = correctotv;
        this.testid = testid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOtv1() {
        return otv1;
    }

    public void setOtv1(String otv1) {
        this.otv1 = otv1;
    }

    public String getOtv2() {
        return otv2;
    }

    public void setOtv2(String otv2) {
        this.otv2 = otv2;
    }

    public String getOtv3() {
        return otv3;
    }

    public void setOtv3(String otv3) {
        this.otv3 = otv3;
    }

    public String getOtv4() {
        return otv4;
    }

    public void setOtv4(String otv4) {
        this.otv4 = otv4;
    }

    public String getCorrectotv() {
        return correctotv;
    }

    public void setCorrectotv(String correctotv) {
        this.correctotv = correctotv;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }
}
