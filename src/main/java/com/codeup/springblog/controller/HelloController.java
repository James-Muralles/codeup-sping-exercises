package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller//dictates that this class is a controller in (MVC)
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String index(){ //when GET request to "localhost:8080/", run the method directly beneath this
        return "Index page.";// also return the method return String as HTML
    }

    @GetMapping("/hello")
    public String helloSpring(){
        return "/hello";
    }



    @GetMapping("/welcome")
    public String welcomeSpring(){
        return "/welcome";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "/hello";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "/join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "/join";
    }
}
