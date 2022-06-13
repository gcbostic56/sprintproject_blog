package com.example.sprintproject_blog.service;

import java.util.List;

import com.example.sprintproject_blog.model.Post;

public interface PostService {
    List<Post> getAllPosts();

    void savePost(Post post);

    Post getPostById(long id);

    void deletePostById(long id);
}
