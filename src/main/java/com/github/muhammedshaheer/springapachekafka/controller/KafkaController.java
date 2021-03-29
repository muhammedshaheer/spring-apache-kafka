package com.github.muhammedshaheer.springapachekafka.controller;

import com.github.muhammedshaheer.springapachekafka.model.KafkaModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaTemplate<String, KafkaModel> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, KafkaModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void post(@RequestBody KafkaModel kafkaModel) {
        kafkaTemplate.send("MY_TOPIC", kafkaModel);
    }
}
