package com.producer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.producer.dto.Consumer;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;

	/*public void sendMessage(String message) {
		CompletableFuture<SendResult<String, Object>> future = template.send("topic1", message);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent message = " + message + " with off set ::" + result.getRecordMetadata().offset());
			} else {
				System.out.println("Unnable to send the Message." + ex.getMessage());
			}
		});
	}*/
	
	public void sendMessage(Consumer consumer) {
		CompletableFuture<SendResult<String, Object>> future = template.send("topic1", consumer);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent message = " + consumer.toString() + " with off set ::" + result.getRecordMetadata().offset());
			} else {
				System.out.println("Unnable to send the Message." + ex.getMessage());
			}
		});
	}

}
