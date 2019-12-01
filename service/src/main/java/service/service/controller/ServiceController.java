package service.service.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Value("${server.port}")
    String port;

    @GetMapping("/getValue")
    public String getValue(@RequestParam String name) {
        return "hi,this is serviceController" + name + port;
    }
}
