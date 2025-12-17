package com.example.demo.servlet;

import.org.springframework.web.annotation.PostMapping
@WebServlet
public class SimpleEchoServlet{
 @PostMapping("/ping")
 public Simple v(){
    return "PONG"
 }

}