package com.codeup.springblog.controller;

import com.codeup.springblog.Repositories.PostsRepository;
import com.codeup.springblog.Repositories.UserRepository;
import com.codeup.springblog.models.Post;

import com.codeup.springblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostsRepository postRepo;
    private final UserRepository userRepo;

    public PostController(PostsRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;

    }


//    @GetMapping("/posts")// type this in th url
//
//
//    public String showPosts (Model model){//method to show all post when going to /posts
//        ArrayList<Post> posts = new ArrayList<>();//make a new array list to add posts to
//        Post post = new Post();// make a new post
//        post.setBody("I'm gonna be a might king enemies beware...");//set body
//        post.setTitle("King of Codeup: Jimmy");//set title
//        Post postTwo = new Post("Jimmy: The Dark Knight", "Its not who we are underneath, but what we code that defines us");// make a second post
//        posts.add(post);//add the two posts to the list
//        posts.add(postTwo);
//
//        model.addAttribute("posts", posts);// set the attribute of posts to the posts list
//
//        return "posts/index";// return the index html from the posts directory

    //    }

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postRepo.findAll());

        return "posts/index";
    }

    @GetMapping("/post/{id}")
    public String getPost(Model model, @PathVariable long id) {
        model.addAttribute("post", postRepo.getOne(id));
        model.addAttribute("user", userRepo.getOne((long) 1));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreate() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String newPost(
            @RequestParam(name = "title") String titleParam,
            @RequestParam(name = "body") String bodyParam
    ) {
        Post post = new Post();
        post.setTitle(titleParam);
        post.setBody(bodyParam);
        User user = userRepo.getOne((long) 1);
        post.setUser(user);
        this.postRepo.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postRepo.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPost(@PathVariable long id, Model model) {
        Post editedPost = postRepo.getOne(id);
        model.addAttribute("post", editedPost);
        return ("/posts/edit");
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post postToEdit = postRepo.getOne(id);
        postToEdit.setTitle(title);
        postToEdit.setBody(body);
        postRepo.save(postToEdit);

        return ("redirect:/posts");
    }

    @RequestMapping("posts/search")
    public String searchForPosts(@RequestParam("search") String search, Model model) {
        model.addAttribute("posts", postRepo.findByTitleContaining(search));
        model.addAttribute("search", search);
        return "/posts/search-index";
    }

//        @PostMapping("/posts/search")
//                public String searchPost(@RequestParam(name="search") String search, Model model){
//            model.addAttribute("posts", postRepo.findByTitleContaining(search));
//
//
//            return "redirect:posts/search";
//        }

//        @WebServlet(name = "controllers.AdsSearchServlet", urlPatterns = "/ads/search")
//        public class AdsSearchServlet extends HttpServlet {
//            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//                String search = request.getParameter("search");
//                try{
//                    request.setAttribute("ads", DaoFactory.getAdsDao().findAdsByName(search));
//                    request.getRequestDispatcher("/WEB-INF/ads/viewsearch.jsp").forward(request, response);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }


//    @GetMapping("/posts/{id}")
//
//    public String showPost(@PathVariable long id, Model model) {
//        Post post = new Post();// make a post
//        post.setBody("body");//set body
//        post.setTitle("title");// set title
//        model.addAttribute("post", post);//give the post attribute the value of the post that you made
//        return "posts/show";// return the html page show from the posts directory
//    }

//    @GetMapping("/posts/create")
//    @ResponseBody
//
//    public String viewForm (){
//        return "view the form for creating a post";
//    }

//    @PostMapping("/posts/create")
//    @ResponseBody
//
//    public String createPost (){
//        return "create a new post";
//    }

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