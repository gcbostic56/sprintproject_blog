package com.example.sprintproject_blog.repository;


import com.example.sprintproject_blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}