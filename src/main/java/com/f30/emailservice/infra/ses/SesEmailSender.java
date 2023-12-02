package com.f30.emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.f30.emailservice.core.exceptions.EmailServiceException;
import com.f30.emailservice.adapters.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    private static final String EMAIL_NOT_SENT = "Failure while sending e-mail";

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService emailService) {
        this.amazonSimpleEmailService = emailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {

        var request = new SendEmailRequest()
                .withSource("youremail@example.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );

        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException e) {
            throw new EmailServiceException(EMAIL_NOT_SENT, e);
        }
    }
}
