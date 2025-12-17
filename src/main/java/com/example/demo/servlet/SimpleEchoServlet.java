package com.example.demo.servlet;

@WebServlet
public class SimpleEchoServlet{
 @PostMapping("/ping")
 public Simple v(){
    retur "PONG"
 }
 
}