package pl.bsolga;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String hello() {
        return "Hello Bartosz";
    }
}
