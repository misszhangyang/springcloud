package configclient.configclient.configController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${foo}")
    String foo;

    @Value("${democonfigclient.message}")
    String message;

    @RequestMapping(value = "/getConfig")
    public String getConfig(){
        return foo;
    }

    @RequestMapping("/getMessage")
    public String getMessage(){
        return message;
    }
}
