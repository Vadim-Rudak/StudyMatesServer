package org.example.bookfd.domain.chat;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;

    private String name;
    private Integer usercreate;

    public Chat(String name, Integer usercreate) {
        this.name = name;
        this.usercreate = usercreate;
    }
}
