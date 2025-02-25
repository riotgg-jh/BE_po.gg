package com.riot.pogg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoggController {

    @GetMapping("/")
    public String home() {
        return "findpuuid";
    }
}
