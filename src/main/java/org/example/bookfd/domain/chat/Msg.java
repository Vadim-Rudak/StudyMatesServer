package org.example.bookfd.domain.chat;

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
@Table(name = "msg")
public class Msg {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ID;

    private Integer chatid;
    private Integer usertosendid;
    private Integer type;
    private Integer timesend;
    private String res;

}
