package org.example.bookfd.domain;


import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class AllNamesBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    private int numclass;
    private String namebook;
    private String imagebook;
//    private boolean faleinbd;

    public AllNamesBooks() {
    }

    public AllNamesBooks(int numclass, String namebook) {
        this.numclass = numclass;
        this.namebook = namebook;
    }

    public AllNamesBooks(int id, int numclass, String namebook, String imagebook) {
        super();
        this.id = id;
        this.numclass = numclass;
        this.namebook = namebook;
        this.imagebook = imagebook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumclass() {
        return numclass;
    }

    public void setNumclass(int numclass) {
        this.numclass = numclass;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public String getImagebook() {
        return imagebook;
    }

    public void setImagebook(String imagebook) {
        this.imagebook = imagebook;
    }
}
