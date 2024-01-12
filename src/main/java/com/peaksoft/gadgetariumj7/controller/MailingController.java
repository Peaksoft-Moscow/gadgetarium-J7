package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.EmailRequest;
import com.peaksoft.gadgetariumj7.model.dto.EmailResponse;
import com.peaksoft.gadgetariumj7.service.MailingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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
public class MailingController {

    MailingService mailingService;

    @SneakyThrows
    @PostMapping("/mail")
    public ResponseEntity<EmailResponse> mail(@RequestBody EmailRequest request) {
        log.info("Mailing successfully created");
        EmailResponse response = mailingService.createMailing(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}