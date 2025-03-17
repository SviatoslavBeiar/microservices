package org.example.currencyconversionmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionMicroserviceApplication.class, args);
    }

}
