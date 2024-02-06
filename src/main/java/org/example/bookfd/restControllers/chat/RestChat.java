package org.example.bookfd.restControllers.chat;

import org.example.bookfd.domain.chat.Chat;
import org.example.bookfd.domain.chat.Msg;
import org.example.bookfd.domain.chat.UsersInChat;
import org.example.bookfd.repos.chat.ChatRepo;
import org.example.bookfd.repos.chat.MsgRepo;
import org.example.bookfd.repos.chat.UsersInChatRepo;
import org.example.bookfd.response.ChatInfo;
import org.example.bookfd.response.SendMsg;
import org.example.bookfd.webSocket.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestChat {

    @Autowired
    private MyHandler myHandler;

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
        System.out.println("F1" + nameChat);
        System.out.println("F2" + idUserCreate);
        System.out.println("F3" + msg.toString());


        SendMsg sendMsg = new SendMsg();
        Chat chat = chatRepo.findByID(msg.getChatid());
        if (chat==null){
            Chat newChat = new Chat(nameChat,idUserCreate);
            chatRepo.save(newChat);

            System.out.println(newChat.getID());

            UsersInChat usersInChat1 = new UsersInChat(0,newChat.getID(),idUserCreate,0);
            UsersInChat usersInChat2 = new UsersInChat(0,newChat.getID(),msg.getUsertosendid(),0);

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

        boolean hasSend = myHandler.sendMessageToUser(idUserCreate, new TextMessage("UpdateInfoChat"));
        boolean hasSend2 = myHandler.sendMessageToUser(msg.getUsertosendid(), new TextMessage("UpdateInfoChat"));
        System.out.println(hasSend);
        System.out.println(hasSend2);

        sendMsg.setMsg(msg);
        sendMsg.setStatusSend(true);
        return msg;
    }

    @GetMapping(value = "/getChatsInfo",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAllInfoChat(
            @RequestParam(name="user_id", required=false, defaultValue="0") int userId,
            @RequestParam(name="id_last_message", required=false, defaultValue="0") int idLastMessage
    ) throws IOException {

        List<Integer> listChats = new ArrayList<>();

        usersInChatRepo.findByuserid(userId).forEach(it->
               listChats.add(it.getChatid())
        );

        List<UsersInChat> usersInChatList = usersInChatRepo.findBychatidIn(listChats);
        usersInChatList.removeIf(user-> user.getUserid() == userId);

        List<Msg> listMessages = msgRepo.findBychatidIn(listChats);
        listMessages.removeIf(msg->msg.getID()<=idLastMessage);

        return new ChatInfo(usersInChatList,listMessages);
    }

}