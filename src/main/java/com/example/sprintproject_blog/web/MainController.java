package com.example.sprintproject_blog.web;

import java.util.List;
import java.util.stream.Collectors;

import com.example.sprintproject_blog.model.User;
import com.example.sprintproject_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        // List<Post> latest5Posts = postService.findLatest5();
        // model.addAttribute("latest5posts", latest5Posts);

        // model.addAttribute("listPosts", postService.getAllPosts());
    
    return findPaginated(1, model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 3;
        Page<Post> page = postService.findPaginated(pageNo, pageSize);
        List<Post> listPosts = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("listPosts", listPosts);
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

    @Autowired
    private UserService userService;
    @GetMapping("/usersTable")
    public String showUsersTable(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
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
