package com.cesarochoa.modulith.notification;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Notification {
    private NotificationType type;
    private String message;
    private final OffsetDateTime date;

    Notification(){
        this(null, null);
    }

    Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
        this.date = OffsetDateTime.now();
    }
}
