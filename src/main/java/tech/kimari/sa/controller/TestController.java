package tech.kimari.sa.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @GetMapping(path = "string")
    public String getString(){
        return "Chaîne de caractères transmise par SA";
    }
    @GetMapping
    public List<String> getList(){
        return List.of("Chaîne de caractères", "transmise par SA");
    }
}
