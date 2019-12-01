package amqp.amqp.amqpcontroller;

import amqp.amqp.send.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpController {

    @Autowired
    private SendMessage sender;

    @GetMapping("/sendMessage")
    public String hello(){
        sender.send();
        return "ribbitmq消息已发送成功";
    }

    @GetMapping("/sendWelcome")
    public String getMessage(){
        sender.sendWelcome();
        return "welcome队列已经发送完成";
    }
}
