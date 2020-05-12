package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/land")
    @ResponseBody

    public String LandingPage() {
        return "This is a landing page!";

    }

    @GetMapping("/home")
    @ResponseBody

    public String HomePage() {
        return "This is a home page!";
    }

    @GetMapping("/roll-dice")
    public String rollPage() {
        return "/roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollGuess(@PathVariable int guess, Model model) {
        int randNum = (int) Math.ceil(Math.random() * 6);
        String message;
        if (randNum == guess) {
            message = "You guessed " + guess + " and the die landed on " + randNum + " , you guessed right";
        } else {
            message = "You guessed " + guess + " and the die landed on " + randNum + " , you guessed wrong";
        }
        model.addAttribute("message", message);
        return "/roll-dice";
    }



}