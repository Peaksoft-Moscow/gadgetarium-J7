package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.MailRequest;
import com.peaksoft.gadgetariumj7.model.dto.MailResponse;
import com.peaksoft.gadgetariumj7.service.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MailController {

    EmailService emailService;

    @PostMapping("/mail")
    public ResponseEntity<MailResponse> mail(@RequestBody MailRequest request) {
        log.info("Email successfully created");
        MailResponse response = emailService.Email(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}