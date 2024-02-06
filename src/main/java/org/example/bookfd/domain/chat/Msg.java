package org.example.bookfd.domain.chat;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "msg")
public class Msg {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;

    private Integer chatid;
    private Integer usertosendid;
    private Integer type;
    private Integer timesend;
    private String res;

}
