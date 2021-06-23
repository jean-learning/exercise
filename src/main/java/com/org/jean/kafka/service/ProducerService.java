package com.org.jean.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
public class ProducerService {
    @Value("${spring.kafka.topic}")
    private String topicName;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String msg) {
        kafkaTemplate.send(topicName, msg);
    }

    @Scheduled(fixedRate = 5000)
    public void produceMessage(){
        JSONObject jsonObject = new JSONObject();
//        int min = 0, max = 100;
//        jsonObject.put("id",new Random().nextInt(max - min + 1) + min);

        UUID uuid = UUID.randomUUID();
        jsonObject.put("id",uuid);
        jsonObject.put("timeStamp",new Timestamp(System.currentTimeMillis()));
        sendMessage(jsonObject.toString());
        log.info("{} sent",jsonObject.toString());
    }
}
