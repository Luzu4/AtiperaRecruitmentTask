package com.example.atipera.client.controller;

import com.example.atipera.client.service.ClientService;
import com.example.atipera.exceptionHandler.dto.CustomExceptionError;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllOwnRepositories(@PathVariable String userName, @RequestHeader(HttpHeaders.ACCEPT) String acceptHeader) {
        if (!acceptHeader.equals("application/json")) {
            CustomExceptionError customExceptionError = new CustomExceptionError(406, "Invalid Accept header. Only 'application/json' is allowed.");
            return ResponseEntity.status(customExceptionError.getStatus()).contentType(MediaType.APPLICATION_JSON).body(customExceptionError);
        }
        return clientService.getAllOwnRepositoriesByUsername(userName);
    }
}
