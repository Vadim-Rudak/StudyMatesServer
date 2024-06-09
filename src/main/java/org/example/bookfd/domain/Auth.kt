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
@Table(name = "autoriz")
public class Auth {

    @Id
    private int id;
    private boolean active;
    private String login;
    private String password;
    private String role;

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", active=" + active +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
