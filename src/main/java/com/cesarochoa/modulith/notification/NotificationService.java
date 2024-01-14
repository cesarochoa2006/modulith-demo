package com.cesarochoa.modulith.notification;

import com.cesarochoa.modulith.notification.internal.Notification;
import com.cesarochoa.modulith.notification.internal.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    private void sendProductNotification(String productName, NotificationType notificationType) {
        log.info("Sending {} notification", new Notification(notificationType, "Product created: " + productName));
    }

    public void sendProductEmailNotification(String productName) {
        sendProductNotification(productName, NotificationType.EMAIL);
    }

    public void sendProductSmsNotification(String productName) {
        sendProductNotification(productName, NotificationType.SMS);
    }
}
