package com.f30.emailservice.resources.impl;

import com.f30.emailservice.application.EmailSenderService;
import com.f30.emailservice.core.EmailRequest;
import com.f30.emailservice.core.exceptions.EmailServiceException;
import com.f30.emailservice.resources.EmailResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/email")
public class EmailResourceImpl implements EmailResource {

    private final EmailSenderService emailSenderService;

    @Override
    public ResponseEntity<String> sendEmail(EmailRequest request) {
        try {
            this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email Send Successfully!");
        }
        catch (EmailServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
