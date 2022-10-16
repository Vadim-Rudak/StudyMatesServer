package org.example.bookfd;


import org.example.bookfd.domain.Message;
import org.example.bookfd.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JController {

    @Autowired
    private MessageRepo MessageRepo;


    //(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)





    @RequestMapping(value = "/vv", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object ms(Map<String, Object> model)  {
//        Message ms = new Message();
//        ms.setId(54);
//        ms.setText("gygygndj2");
//        ms.setTag("gygyg");
        Iterable<Message> messages = MessageRepo.findByTagAndId("ghrih",8);
        return messages;


    }


}
