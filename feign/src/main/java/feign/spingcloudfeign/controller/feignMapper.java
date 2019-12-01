package feign.spingcloudfeign.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service")
public interface feignMapper {

    @GetMapping("/getValue")
    String getValyeFromService(@RequestParam(value = "name") String name);
}
