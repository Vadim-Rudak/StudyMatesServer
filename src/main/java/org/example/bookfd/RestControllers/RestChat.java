package org.example.bookfd.RestControllers;

import org.example.bookfd.domain.chat.Chat;
import org.example.bookfd.domain.chat.Msg;
import org.example.bookfd.domain.chat.UsersInChat;
import org.example.bookfd.repos.chat.ChatRepo;
import org.example.bookfd.repos.chat.MsgRepo;
import org.example.bookfd.repos.chat.UsersInChatRepo;
import org.example.bookfd.response.SendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RestChat {

    @Autowired
    private ChatRepo chatRepo;

    @Autowired
    private MsgRepo msgRepo;

    @Autowired
    private UsersInChatRepo usersInChatRepo;



    @PostMapping(value = "/sendMessage",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object sendMessage(@RequestParam(name="name_chat", required=false, defaultValue="11") String nameChat,
                              @RequestParam(name="id_user_create", required=false, defaultValue="11") int idUserCreate,
                              @RequestBody Msg msg) throws IOException {
        SendMsg sendMsg = new SendMsg();
        Chat chat = chatRepo.findByID(msg.getChatid());
        if (chat==null){
            Chat newChat = new Chat(nameChat,idUserCreate);
            chatRepo.save(newChat);

            UsersInChat usersInChat1 = new UsersInChat(newChat.getID(),idUserCreate,false);
            UsersInChat usersInChat2 = new UsersInChat(newChat.getID(),msg.getUsertosendid(),false);

            usersInChatRepo.save(usersInChat1);
            usersInChatRepo.save(usersInChat2);
            msg.setChatid(newChat.getID());

            sendMsg.setChat(newChat);

        }else{
            msg.setChatid(chat.getID());
            sendMsg.setChat(chat);
        }
        //add time send message////////////////////////////////////////////////
        msgRepo.save(msg);

        sendMsg.setMsg(msg);
        sendMsg.setStatusSend(true);
        return sendMsg;
    }



}
