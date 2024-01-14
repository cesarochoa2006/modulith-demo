package com.cesarochoa.modulith;

import com.cesarochoa.modulith.notification.NotificationService;
import com.cesarochoa.modulith.product.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        var applicationContext = SpringApplication.run(Application.class, args);

        applicationContext.getBean(NotificationService.class)
                .sendProductSmsNotification("Test notification product sends test sms when app starts");

        applicationContext
                .getBean(ProductService.class)
                .createProduct("Product 1", "Description 1", 100.0
                );
    }

}
