package com.example.demo.servlet;

import.org.springframework.web.annotation.GetMapping;
@WebServlet
public class SimpleEchoServlet{
 @GetMapping("/ping")
 public String v(){
    return "PONG"
 }
 @GetMapping("/health")
 public String he(){
    return "OK";
 }

}