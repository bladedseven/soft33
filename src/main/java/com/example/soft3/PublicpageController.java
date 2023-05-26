package com.example.soft3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicpageController {

    @GetMapping("/publicpage")
    public String publicpage(){
        return "publicpage";
    }
//    @GetMapping("/index")
//    public String index(){
//        return "index";
//    }
//    @GetMapping("/search")
//    public String search(){
//        return "search";
//    }
}
