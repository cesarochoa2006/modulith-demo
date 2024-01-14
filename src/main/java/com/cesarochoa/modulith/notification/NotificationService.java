package com.cesarochoa.modulith.notification;

import com.cesarochoa.modulith.notification.internal.Notification;
import com.cesarochoa.modulith.notification.internal.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

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

    @Async
    @TransactionalEventListener
    public void onNotificationEvent(NotificationDTO event) {
        var notification = toEntity(event);
        switch (notification.getType()) {
            case EMAIL -> sendProductEmailNotification(notification.getMessage());
            case SMS -> sendProductSmsNotification(notification.getMessage());
            default -> throw new UnsupportedOperationException("Sent Notification type is invalid");
        }
        log.info("NotificationListener: {}", event);
    }

    private Notification toEntity(NotificationDTO notificationDTO) {
        NotificationType type;
        try {
            type = NotificationType.valueOf(notificationDTO.type());
        } catch (IllegalArgumentException e) {
            log.error("Notification type not found: {}", notificationDTO.type());
            throw new UnsupportedOperationException("Sent Notification type is invalid");
        }
        return new Notification(type, notificationDTO.message());
    }
}
