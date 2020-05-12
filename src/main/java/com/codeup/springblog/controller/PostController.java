package com.codeup.springblog.controller;

import com.codeup.springblog.models.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")// type this in th url


    public String showPosts (Model model){//method to show all post when going to /posts
        ArrayList<Post> posts = new ArrayList<>();//make a new array list to add posts to
        Post post = new Post();// make a new post
        post.setBody("I'm gonna be a might king enemies beware...");//set body
        post.setTitle("King of Codeup: Jimmy");//set title
        Post postTwo = new Post("Jimmy: The Dark Knight", "Its not who we are underneath, but what we code that defines us");// make a second post
        posts.add(post);//add the two posts to the list
        posts.add(postTwo);

        model.addAttribute("posts", posts);// set the attribute of posts to the posts list

        return "posts/index";// return the index html from the posts directory

    }

    @GetMapping("/posts/{id}")


    public String showPost (@PathVariable long id, Model model){
        Post post = new Post();// make a post
        post.setBody("body");//set body
        post.setTitle("title");// set title
        model.addAttribute("post", post);//give the post attribute the value of the post that you made
        return "posts/show";// return the html page show from the posts directory
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
