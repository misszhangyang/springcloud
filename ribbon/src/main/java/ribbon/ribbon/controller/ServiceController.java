package ribbon.ribbon.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ServiceController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon")
    @HystrixCommand(fallbackMethod  = "helloError")
    public String getValue(@RequestParam String name) {
        Map<String,Object> hashmap = new LinkedHashMap<>();
        return restTemplate.getForObject("http://service/getValue?name="+name,String.class);
    }

    public String helloError(String name){
        return  "hi"+name+",服务器出现故障,很抱歉";
    }
}
