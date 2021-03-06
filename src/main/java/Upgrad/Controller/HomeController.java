package Upgrad.Controller;

import Upgrad.Model.Post;
import Upgrad.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    public HomeController(){
        System.out.println("**** HomeController ****");
    }

    @Autowired
    private PostService postservice;

    @RequestMapping("/")
    public String getAllPosts(Model model){

        ArrayList<Post> posts = postservice.getAllPosts();
        model.addAttribute("posts", posts);

        return "index";
    }
}
