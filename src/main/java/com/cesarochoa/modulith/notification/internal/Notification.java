package com.cesarochoa.modulith.notification.internal;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Notification {
    private NotificationType type;
    private String message;
    private final OffsetDateTime date;

    public Notification(){
        this(null, null);
    }

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
        this.date = OffsetDateTime.now();
    }
}
