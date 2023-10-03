package com.arthurfrei;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    private final JmsProducer producer;

    private final String destination;

    public Controller(JmsProducer producer, @Value("${activemq.destination}") String destination) {
        this.producer = producer;
        this.destination = destination;
    }

    @PostMapping("/")
    public String sendMessage(@RequestBody Student student) {
        producer.sendTo(destination, student);
        return "success";
    }
}
