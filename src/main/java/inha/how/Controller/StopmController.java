package inha.how.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class StopmController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/send")
    @SendTo
    public void sendMsg(@Payload Map<String,Object> data){

        int a=1;

        simpMessagingTemplate.convertAndSend("/topic/1", a);
    }
}
