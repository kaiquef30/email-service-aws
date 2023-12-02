package com.f30.emailservice.resources;

import com.f30.emailservice.core.EmailRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmailResource {

    @PostMapping
    ResponseEntity<String> sendEmail(@RequestBody EmailRequest request);

}
