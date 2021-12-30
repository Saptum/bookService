package com.example.bookservice.controller;

import com.example.bookservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;


}
