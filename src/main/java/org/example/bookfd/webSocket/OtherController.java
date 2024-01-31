package org.example.bookfd.webSocket;

import org.example.bookfd.response.RegRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;

@Controller
public class OtherController {

    @Autowired
    private MyHandler myHandler;


    @RequestMapping(value = "/send_new_Message1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object sendMessage() {

        boolean hasSend = myHandler.sendMessageToUser(150, new TextMessage("Отправить маленький xi"));
        System.out.println(hasSend);


        return new RegRequestModel(200,"465",true);
    }


}
