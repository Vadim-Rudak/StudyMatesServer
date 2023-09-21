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
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    private String name;
    private String lastName;
    private String gender;
    private String dateBirthday;
    private String cityLive;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateBirthday='" + dateBirthday + '\'' +
                ", cityLive='" + cityLive + '\'' +
                '}';
    }
}
