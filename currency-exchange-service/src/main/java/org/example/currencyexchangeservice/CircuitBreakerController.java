package org.example.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger
            logger = LoggerFactory.getLogger(CircuitBreakerController.class);

     @GetMapping("/sample-api")
   // @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
   // @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")

     @RateLimiter(name = "default")
     //10s => 10000
     @Bulkhead(name= "sample-api")
    public  String sample(){

       logger.info("Sample Api call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/huita", String.class);

       // return forEntity.getBody();
         return "success";
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response " + ex.getMessage();
    }
}
