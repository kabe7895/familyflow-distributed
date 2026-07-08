package de.familyflow.notification_service;

import de.familyflow.notification_service.dto.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void processNotification(NotificationRequest request) {

        System.out.println("=================================");
        System.out.println("Notification received");
        System.out.println("Type: " + request.getType());
        System.out.println("Message: " + request.getMessage());
        System.out.println("=================================");
    }
}