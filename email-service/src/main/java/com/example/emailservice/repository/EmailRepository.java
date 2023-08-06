package com.example.emailservice.repository;

import com.example.emailservice.entity.EmailRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailRequest, String> {
}
