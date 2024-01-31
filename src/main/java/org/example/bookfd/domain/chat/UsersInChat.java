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
@Table(name = "usrchat")
public class UsersInChat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ID;

    private Integer chatid;
    private Integer userid;
    private Boolean group;

    public UsersInChat(Integer chatid, Integer userid, Boolean group) {
        this.chatid = chatid;
        this.userid = userid;
        this.group = group;
    }
}
