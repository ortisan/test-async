package br.ortiz.controllers;

import br.ortiz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    private String test() throws Exception {
        return testService.sayHello();
    }

    @GetMapping("/testasync")
    private String testAsync() throws Exception {
        Integer number = 1 + (int) (Math.random() * (5 + 1));
        Thread.sleep(number * 1000);
        return "Waited by " + number + " sec";
    }
}
