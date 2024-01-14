package com.cesarochoa.modulith.product;

import com.cesarochoa.modulith.notification.NotificationService;
import com.cesarochoa.modulith.product.internal.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final NotificationService notificationService;

    public Product createProduct(String name, String description, double price) {
        var product = new Product().setName(name).setDescription(description).setPrice(price);
        log.info("Product created: {}", product);
        notificationService.sendProductEmailNotification(name);
        return product;
    }

}
