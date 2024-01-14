package com.cesarochoa.modulith.product;

import com.cesarochoa.modulith.notification.NotificationDTO;
import com.cesarochoa.modulith.notification.NotificationService;
import com.cesarochoa.modulith.product.internal.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final NotificationService notificationService;

    private final ApplicationEventPublisher events;

    public Product createProduct(String name, String description, double price) {
        var product = new Product().setName(name).setDescription(description).setPrice(price);
        log.info("Product created: {}", product);
        notificationService.sendProductEmailNotification(name);
        return product;
    }

    @Transactional
    public Product createProductSmsEvent(String name, String description, double price) {
        var product = new Product().setName(name).setDescription(description).setPrice(price);
        log.info("Product created: {}", product);
        events.publishEvent(new NotificationDTO("SMS", name));
        return product;
    }

}
