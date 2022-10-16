package org.example.bookfd.domain;


import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Validated
public class TestsNames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @NotBlank(message = "Заполните поле")
    private String subject;

    @NotNull(message = "Заполните поле")
    private int numclass;

    @NotBlank(message = "Заполните поле")
    private String nametest;
    private int numquestions;

    public TestsNames() {

    }

    public TestsNames(Integer id, String subject, int numclass, String nametest, int numquestions) {
        this.id = id;
        this.subject = subject;
        this.numclass = numclass;
        this.nametest = nametest;
        this.numquestions = numquestions;
    }

    public int getNumquestions() {
        return numquestions;
    }

    public void setNumquestions(int num_questions) {
        this.numquestions = num_questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getNumclass() {
        return numclass;
    }

    public void setNumclass(int numclass) {
        this.numclass = numclass;
    }

    public String getNametest() {
        return nametest;
    }

    public void setNametest(String nametest) {
        this.nametest = nametest;
    }

}
