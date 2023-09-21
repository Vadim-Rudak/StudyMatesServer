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
@Table(name = "photo")
public class Photo {

    @Id
    private int id;
    private boolean verification;
    private String name;
    private String res;
    private String path;
}
