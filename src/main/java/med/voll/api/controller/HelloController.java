package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Spring MVC /// anotacao usada para api rest
@RequestMapping("/hello") // url que o programa vai responder
public class HelloController {

    @GetMapping
    public String olaMundo(){
        return "Hellow Word Springg";
    }

}
