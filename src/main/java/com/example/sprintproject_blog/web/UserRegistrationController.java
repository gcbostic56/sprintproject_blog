package com.example.sprintproject_blog.web;

import java.sql.SQLOutput;
import java.util.Optional;

import com.example.sprintproject_blog.model.User;
import com.example.sprintproject_blog.service.UserService;
import com.example.sprintproject_blog.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto registrationDto,
                                      BindingResult result) {

        System.out.println(registrationDto);
            System.out.println(registrationDto);
            userService.save(registrationDto);
            return "redirect:/registration?success";

    }
}