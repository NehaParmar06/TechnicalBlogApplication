package Upgrad.Controller;

import Upgrad.Model.Post;
import Upgrad.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private PostService postservice;

    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration(){
        return "users/registration";
    }

    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(){
        return "redirect:/posts";
    }

    @RequestMapping(value = "users/logout", method= RequestMethod.POST)
    public String logout(Model model){

        ArrayList<Post> posts = postservice.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

}
