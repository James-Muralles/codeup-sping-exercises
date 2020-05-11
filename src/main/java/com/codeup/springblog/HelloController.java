package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//dictates that this class is a controller in (MVC)
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String index(){ //when GET request to "localhost:8080/", run the method directly beneath this
        return "Index page.";// also return the method return String as HTML
    }

    @GetMapping("/hello")
    @ResponseBody
    public String helloSpring(){
        return "Hello from Spring!";
    }
}
