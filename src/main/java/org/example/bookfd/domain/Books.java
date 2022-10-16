package org.example.bookfd.domain;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ID;
    private Integer numclass;
    private String namebook;
    private String resbook;
    private int idbook;

    public Books() {
    }

    public Books(int numclass, String namebook, String resbook) {
        super();
        this.numclass = numclass;
        this.namebook = namebook;
        this.resbook = resbook;
    }

    public Books(Integer ID, int numclass, String namebook, String resbook) {
        super();
        this.ID = ID;
        this.numclass = numclass;
        this.namebook = namebook;
        this.resbook = resbook;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setNumclass(int numclass) {
        this.numclass = numclass;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public void setResbook(String resbook) {
        this.resbook = resbook;
    }

    public Integer getID() {
        return ID;
    }

    public int getNumclass() {
        return numclass;
    }

    public String getNamebook() {
        return namebook;
    }

    public String getResbook() {
        return resbook;
    }

    public void setNumclass(Integer numclass) {
        this.numclass = numclass;
    }

    public int getIdbook() {
        return idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }
}
