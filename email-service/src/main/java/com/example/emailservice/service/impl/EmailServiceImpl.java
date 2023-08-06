package com.example.emailservice.service.impl;

import com.example.emailservice.dto.EmailRequestDto;
import com.example.emailservice.entity.EmailRequest;
import com.example.emailservice.repository.EmailRepository;
import com.example.emailservice.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;


    @Override
    public EmailRequestDto createAndSaveEmail(EmailRequest emailRequest) {
        log.info("Inside createAndSaveEmail");
        emailRequest.setNotificationId(UUID.randomUUID().toString());
        return mapToDto(emailRepository.save(emailRequest));
    }

    @Override
    public List<EmailRequestDto> getAll() {
        log.info("Inside getAll");
        return emailRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private EmailRequestDto mapToDto(EmailRequest emailRequest) {
        return EmailRequestDto.builder()
                .notificationId(emailRequest.getNotificationId())
                .from(emailRequest.getEmailFrom())
                .to(emailRequest.getEmailTo())
                .subject(emailRequest.getEmailSubject())
                .body(emailRequest.getEmailBody())
                .build();
    }
}
