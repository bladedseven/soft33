package com.example.soft3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String search(){
        return "search2";
    }
}
