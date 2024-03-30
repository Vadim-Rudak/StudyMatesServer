package org.example.bookfd.domain.chat;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usrchat")
public class UsersInChat {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;

    private int chatid;
    private int userid;
    private int gr;

    public UsersInChat(int chatid, int userid, int gr) {
        this.chatid = chatid;
        this.userid = userid;
        this.gr = gr;
    }
}
