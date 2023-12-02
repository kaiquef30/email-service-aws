package com.f30.emailservice.adapters;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);

}
