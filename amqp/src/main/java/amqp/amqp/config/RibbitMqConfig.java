package amqp.amqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建rabbitmq 的配置类，用来配置队列，交换机，路由等高级信息。我这里只配了一个队列
 */
@Configuration
public class RibbitMqConfig {

    @Bean
    public Queue helloQueue(){
        return  new Queue("hello");
    }

    @Bean
    public Queue welcomeQueue(){
        return new Queue("welcome");
    }
}
