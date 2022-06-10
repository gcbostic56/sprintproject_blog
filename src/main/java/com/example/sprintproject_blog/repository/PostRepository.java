package com.example.sprintproject_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sprintproject_blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
}
