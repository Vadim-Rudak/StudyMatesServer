package org.example.bookfd.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bookfd.domain.chat.Msg;
import org.example.bookfd.domain.chat.UsersInChat;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatInfo {
    List<UsersInChat> usersInChatList;
    List<Msg> messagesList;
}
