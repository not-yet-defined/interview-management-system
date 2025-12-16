package com.flatirons.interview.notificationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private static final Logger log =
            LoggerFactory.getLogger(NotificationController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void notifyCandidate(@RequestBody String message) {
        log.info("Notification received: {}", message);
    }
}