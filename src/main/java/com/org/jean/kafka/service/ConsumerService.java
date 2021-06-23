package com.org.jean.kafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.jean.elasticSearch.service.ESService;
import com.org.jean.mysql.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;


import java.util.List;
@Slf4j
@Service
public class ConsumerService {
    @Autowired
    ESService esService;

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(List<ConsumerRecord<Object, Object>> records, Acknowledgment acknowledgment, Consumer consumer){
        try {
            records.parallelStream().forEach(record -> {
                log.info(record.value().toString() + " received");

//                    Student student = new ObjectMapper().readValue(record.value().toString(), Student.class);
//                    JSONParser parser = new JSONParser();
//                    JSONObject json = (JSONObject) parser.parse(stringToParse);
                JSONObject jsonObject = new JSONObject(record.value().toString());
                Student student = new Student();
                student.setId(jsonObject.get("id").toString());
                esService.addStudent(student);
            });

            acknowledgment.acknowledge();
        } catch (Exception e){
            log.warn(e.toString());
            TopicPartition topicPartition = new TopicPartition(records.get(0).topic(), records.get(0).partition());
            OffsetAndMetadata metadata = consumer.committed(topicPartition);
            consumer.seek(topicPartition, metadata.offset());
        }
    }
}
