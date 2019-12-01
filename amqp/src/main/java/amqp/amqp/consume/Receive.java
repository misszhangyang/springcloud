package amqp.amqp.consume;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receive {

    @RabbitListener(queues = "hello")
    @RabbitHandler//指定对消息的处理方法
    public  void process(String hello){
        System.out.println("Receiver:"+hello);
    }

    @RabbitHandler
    @RabbitListener(queues = "welcome")
    public void receiveMessage(String welcome){
        System.out.println("welcome queue");
    }
}
