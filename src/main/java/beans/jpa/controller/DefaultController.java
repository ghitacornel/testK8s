package beans.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping
public class DefaultController {

    @GetMapping
    public String root() {
        return "hello k8s " + new Date();
    }

}
