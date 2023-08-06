package com.example.emailservice.controller;

import com.example.emailservice.dto.EmailRequestDto;
import com.example.emailservice.entity.EmailRequest;
import com.example.emailservice.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/notifications/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/")
    public ResponseEntity<EmailRequestDto> createEmail(@RequestBody EmailRequest emailRequest) {
        return new ResponseEntity<>(emailService.createAndSaveEmail(emailRequest), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmailRequestDto>> getAllNotifications() {
        return ResponseEntity.ok(emailService.getAll());
    }


}
