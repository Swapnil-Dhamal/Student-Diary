package com.swapnil.PetCare_System.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.swapnil.PetCare_System.model.NotificationRequest;

@RestController
public class NotificationController {

    private final SimpMessagingTemplate messagingTemplate;


    public NotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/api/notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        messagingTemplate.convertAndSend("/topic/notifications", notificationRequest.getMessage() );
    }
}
