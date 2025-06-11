package com.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

	Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

	
	@KafkaListener(topics = "topic1", groupId = "group1")
	public void consumer1(String message) {
		logger.info("consumer1 consumes the message {} ", message);
	}
	
	@KafkaListener(topics = "topic1", groupId = "group1")
	public void consumer2(String message) {
		logger.info("consumer2 consumes the message {} ", message);
	}
	
	@KafkaListener(topics = "topic1", groupId = "group1")
	public void consumer3(String message) {
		logger.info("consumer3 consumes the message {} ", message);
	}
	
	@KafkaListener(topics = "topic1", groupId = "group1")
	public void consumer4(String message) {
		logger.info("consumer4 consumes the message {} ", message);
	}
}
