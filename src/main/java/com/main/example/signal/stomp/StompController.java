package com.main.example.signal.stomp;

import com.main.core.config.signal.stomp.StompMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by superMan791 on 2017/5/6.
 */
@Controller
@RequestMapping("stomp")
public class StompController {
    private static Logger log= LogManager.getLogger();
    @RequestMapping("index")
    public String index(){
        return "signal/stomp/index";
    }

    /**
     * 消息模板
     */
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 接收请求,并发送消息
     * @param message
     */
    @MessageMapping("user01")
    @SendTo("/topic/hello")
    public StompMessage  server(StompMessage message){
    log.info("Server收到消息: "+message);
    messagingTemplate.convertAndSend("/topic/hello",new StompMessage("user01:哈哈哈!"));

    return new StompMessage("user01收到消息了");
    }
    /**
     * 处理对/app/user02的订阅,在客户端第一次订阅时发送消息给客户端
     */
    @SubscribeMapping("user02")
    public StompMessage subServer(){
        StompMessage message=new StompMessage("这是Subscribe消息!");
        return message;
    }
    @MessageMapping("user03")
    @SendTo(value="/topic/hello")
    public StompMessage sendToOne(StompMessage message){
        messagingTemplate.convertAndSendToUser("guest","/topic/hello",new StompMessage("guest,这条消息是爹发给你自己的!"));
        return new StompMessage("这条是你妈发的!");
    }
}
