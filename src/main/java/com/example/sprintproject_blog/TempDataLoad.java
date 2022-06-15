package com.example.sprintproject_blog;

import com.example.sprintproject_blog.model.Post;
import com.example.sprintproject_blog.model.User;
import com.example.sprintproject_blog.repository.PostRepository;
import com.example.sprintproject_blog.repository.UserRepository;
import com.example.sprintproject_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TempDataLoad {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public TempDataLoad(PostRepository postRepository, UserService userService, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        main();
    }

    private void main(){
//        User cameron = new User("Cameron", "Bostic", "cameronbostic1@gmail.com", "password!");
//
//        userRepository.save(cameron);
//        postRepository.save(new Post(
//             "testTitle", cameron, "testBody"
//        ));
    }
}
