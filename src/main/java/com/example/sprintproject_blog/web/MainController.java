package com.example.sprintproject_blog.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sprintproject_blog.model.Post;
import com.example.sprintproject_blog.service.PostService;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model) {
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);

        List<Post> latest3Posts = latest5Posts.stream()
        .limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
    
    return "index";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable(value = "id") long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "view_post";
    }

    @GetMapping("/createNewPost")
    public String createNewPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "new_post";
    }

    @GetMapping("/usersTable")
    public String showUsersTable() {
        return "users_table";
    }

    @PostMapping("/savePost") 
    public String savePost(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/";
        // change redirect to view created post's page
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "edit_post";
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "delete_post";
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable(value = "id") long id) {
        this.postService.deletePostById(id);
        return "redirect:/";
    }
    
}
