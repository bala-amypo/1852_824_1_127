package com.example.demo.servlet;

import.org.springframework.web.annotation.PostMapping;
@WebServlet
public class SimpleEchoServlet{
 @PostMapping("/ping")
 public String v(){
    return "PONG"
 }
 @GMapping("/health")
 public String he(){
    return "OK";
 }

}