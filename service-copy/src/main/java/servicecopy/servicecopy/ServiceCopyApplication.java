package servicecopy.servicecopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceCopyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCopyApplication.class, args);
    }

}
