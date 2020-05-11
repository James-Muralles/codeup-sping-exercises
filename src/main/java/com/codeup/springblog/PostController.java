package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody

    public String showPosts (){
        return "posts index page";

    }

    @GetMapping("/posts/{id}")
    @ResponseBody

    public String showPost (@PathVariable long id){
        return "view an individual post for id: " + id;

    }

    @GetMapping("/posts/create")
    @ResponseBody

    public String viewForm (){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody

    public String createPost (){
        return "create a new post";
    }

//    @GetMapping("/{operation}/{numOne}/{keyword}/{numTwo}")
//    @ResponseBody

//    public String doMath(@PathVariable String operation, @PathVariable int numOne, @PathVariable String keyword, @PathVariable int numTwo){
//
//        switch(operation){
//            case "add":
//                int sum;
//                sum = numOne + numTwo;
//                return Integer.toString(sum);
//
//            case "subtract":
//                int diff;
//                diff = numOne - numTwo;
//                return Integer.toString(diff);
//
//            case "multiply":
//                int product;
//                product = numOne * numTwo;
//                return Integer.toString(product);
//
//            case "divide":
//                int quotient;
//                 quotient = numOne / numTwo;
//                return Integer.toString(quotient);
//
//            default:
//                return "cant do that";
//        }



//    }








}
