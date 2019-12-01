package feign.spingcloudfeign.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class feignController {

    @Autowired
    feignMapper feignMapper;

    @GetMapping("/feign")
    public String getValue(@RequestParam String name){
       return  feignMapper.getValyeFromService(name);
    }

}
