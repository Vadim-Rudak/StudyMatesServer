package org.example.bookfd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school")
public class School {

    @Id
    private int id;
    private String name;
    private String nameCity;
    private int numClass;
    private Boolean endSchool;

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameCity='" + nameCity + '\'' +
                ", numClass=" + numClass +
                ", endSchool=" + endSchool +
                '}';
    }
}
