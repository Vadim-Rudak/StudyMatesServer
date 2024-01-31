package org.example.bookfd.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bookfd.domain.chat.Chat;
import org.example.bookfd.domain.chat.Msg;
import org.example.bookfd.domain.chat.UsersInChat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendMsg {
    private Boolean statusSend = false;
    private Chat chat;
    private UsersInChat userToSend;
    private Msg msg;
}
