package com.istinL3.GestionStock.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String pageIndex(){
        return "index";
    }

}
