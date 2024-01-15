package com.peaksoft.gadgetariumj7.controller;

import com.peaksoft.gadgetariumj7.model.dto.MailingRequest;
import com.peaksoft.gadgetariumj7.model.dto.MailingResponse;
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

    @PostMapping("/mail")
    public ResponseEntity<MailingResponse> mail(@RequestBody MailingRequest request) {
        log.info("Mailing successfully created");
        MailingResponse response = mailingService.createMailing(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}