package net.trollheim.security.ctf.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientForwardController {
    @GetMapping(value = "/app/{path:[^\\.]*}")
    public String forward() {
        return "forward:/app/";
    }
}
    