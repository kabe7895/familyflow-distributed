package de.familyflow.backend.notification;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NotificationClient {

    private final RestTemplate restTemplate = new RestTemplate();


    public void sendNotification(String type, String message) {

        System.out.println(">>> Sending notification to service");
        System.out.println("Type: " + type);
        System.out.println("Message: " + message);


        Map<String,String> body = Map.of(
                "type", type,
                "message", message
        );


        restTemplate.postForObject(
                "http://localhost:8082/notify",
                body,
                Void.class
        );

        System.out.println(">>> Notification sent");
    }
}