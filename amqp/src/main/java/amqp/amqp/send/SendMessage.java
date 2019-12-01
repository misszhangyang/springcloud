package amqp.amqp.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SendMessage {

    @Autowired
    AmqpTemplate amqpTemplate;

    public  void  send(){
        String context="hello+"+new Date();
        System.out.println("Sender:"+context);
        this.amqpTemplate.convertAndSend("hello",context);
    }

    public void sendWelcome(){
        String context = "welcome" + new Date();
        System.out.println("welcome" + context);
        this.amqpTemplate.convertAndSend("welcome",context + "welcome");
    }

}
