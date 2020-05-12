package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{numOne}/and/{numTwo}")
    @ResponseBody
    public String add(@PathVariable long numOne, @PathVariable long numTwo) {
        return "The answer for this addition problem is: " + (numOne + numTwo);

    }

    @GetMapping("/subtract/{numOne}/and/{numTwo}")
    @ResponseBody
    public String minus(@PathVariable long numOne, @PathVariable long numTwo) {
        return "The answer for this addition problem is: " + (numOne - numTwo);
    }

    @GetMapping("/multipy/{numOne}/and/{numTwo}")
    @ResponseBody
    public String multiply(@PathVariable long numOne, @PathVariable long numTwo) {
        return "The answer for this addition problem is: " + (numOne * numTwo);
    }

    @GetMapping("/divide/{numOne}/and/{numTwo}")
    @ResponseBody
    public String divide(@PathVariable long numOne, @PathVariable long numTwo) {
        return "The answer for this addition problem is: " + (numOne / numTwo);
    }
}
