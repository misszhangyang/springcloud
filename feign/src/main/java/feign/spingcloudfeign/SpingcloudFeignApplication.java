package feign.spingcloudfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * feign调用流程，在启动类上添加@EnableFeignClients注解，然后在程序启动的时候会去扫描所有加载了
 * @FeignClient注解的类，并将他们通过jdk代理的方法，生成具体的RestTemplate，然后再将restTemplate
 * 生成具体的request,request再交给client处理，client处理方式默认使用的是ribbon客户端负载均衡的调用方式
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpingcloudFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingcloudFeignApplication.class, args);
    }

}
