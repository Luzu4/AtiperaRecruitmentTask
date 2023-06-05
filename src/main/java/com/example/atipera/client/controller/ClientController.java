package com.example.atipera.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class ClientController {

    @GetMapping("/{userNickName}")
    public ResponseEntity<?> getAllRepositories(@PathVariable String userNickName){
        System.out.println(userNickName);
        return ResponseEntity.ok("ok");
    }
}
