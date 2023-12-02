package com.f30.emailservice.core;

public interface EmailSender {

    void sendEmail(String to, String subject, String body);

}
