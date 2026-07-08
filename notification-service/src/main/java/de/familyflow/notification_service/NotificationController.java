package de.familyflow.notification_service;

import de.familyflow.notification_service.dto.NotificationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public void notify(@RequestBody NotificationRequest request) {
        service.processNotification(request);
    }
}