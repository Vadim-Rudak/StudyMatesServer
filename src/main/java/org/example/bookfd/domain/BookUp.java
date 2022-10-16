package org.example.bookfd.domain;

public class BookUp {
    private int id;
    private String numclass;
    private String namebook;
    private String imagebook;

    public BookUp(int id, String numclass, String namebook, String imagebook) {
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

    public String getNumclass() {
        return numclass;
    }

    public void setNumclass(String numclass) {
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
