package com.peaksoft.gadgetariumj7.controller;
//
//import com.peaksoft.gadgetariumj7.model.dto.MailRequest;
//import com.peaksoft.gadgetariumj7.model.dto.MailResponse;

import com.peaksoft.gadgetariumj7.model.dto.MailRequest;
import com.peaksoft.gadgetariumj7.model.dto.MailResponse;
import com.peaksoft.gadgetariumj7.service.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> mail(@RequestBody MailRequest request) {
        log.info("Email successfully created");
//        MailResponse mailResponse = emailService.mail(request);
        String str = emailService.mail(request);
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

//    @PostMapping("/mail")
//    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
//        emailService.sendEmail(to, subject, body);
//        return "Email sent successfully!";
//    }
}
