package com.example.emailservice.service;

import com.example.emailservice.dto.EmailRequestDto;
import com.example.emailservice.entity.EmailRequest;

import java.util.List;

public interface EmailService {
    EmailRequestDto createAndSaveEmail(EmailRequest emailRequest);

    List<EmailRequestDto> getAll();
}
