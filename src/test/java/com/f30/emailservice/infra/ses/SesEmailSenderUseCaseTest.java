package com.f30.emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.f30.emailservice.core.exceptions.EmailServiceException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SesEmailSenderUseCaseTest {

    @Mock
    private AmazonSimpleEmailService mockEmailService;

    private SesEmailSender sesEmailSender;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        sesEmailSender = new SesEmailSender(mockEmailService);
    }


    @Test
    public void sendEmail_Successful() {

        var expectedRequest = new SendEmailRequest()
                .withSource("youremail@example.com")
                .withDestination(new Destination().withToAddresses("recipient@example.com"))
                .withMessage(new Message()
                        .withSubject(new Content("Test Subject"))
                        .withBody(new Body().withText(new Content("Test Body")))
                );


        sesEmailSender.sendEmail("recipient@example.com", "Test Subject", "Test Body");


        verify(mockEmailService).sendEmail(expectedRequest);
    }

    @Test(expected = EmailServiceException.class)
    public void sendEmail_AmazonServiceException_ThrowsEmailServiceException() {


        when(mockEmailService.sendEmail(any(SendEmailRequest.class)))
                .thenThrow(new AmazonServiceException("Test AmazonServiceException"));


        sesEmailSender.sendEmail("recipient@example.com", "Test Subject", "Test Body");
    }

}
