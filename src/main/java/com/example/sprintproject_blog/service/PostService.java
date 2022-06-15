package com.example.sprintproject_blog.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.sprintproject_blog.model.Post;

public interface PostService {
    List<Post> getAllPosts();

    void savePost(Post post);

    Post getPostById(long id);

    void deletePostById(long id);

    List<Post> findLatest5();

    Page<Post> findPaginated(int pageNo, int pageSize);
}
