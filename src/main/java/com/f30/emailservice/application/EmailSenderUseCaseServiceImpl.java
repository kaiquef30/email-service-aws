package com.f30.emailservice.application;

import com.f30.emailservice.adapters.EmailSenderGateway;
import com.f30.emailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderUseCaseServiceImpl implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderUseCaseServiceImpl(EmailSenderGateway emailGateway) {
        this.emailSenderGateway = emailGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {

    }
}
