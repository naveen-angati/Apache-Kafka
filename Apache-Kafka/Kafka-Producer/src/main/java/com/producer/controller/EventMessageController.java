package com.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.dto.Consumer;
import com.producer.service.KafkaMessagePublisher;

@RestController
@RequestMapping("/producer-app")
public class EventMessageController {

	@Autowired
	private KafkaMessagePublisher kafkaMessagePublisher;

	/*@GetMapping("/publish/{messaage}")
	public ResponseEntity<?> publishMessage(@PathVariable String messaage) {
		try {
			for (int i = 0; i < 10000; i++) {
				kafkaMessagePublisher.sendMessage(messaage);
			}
			return ResponseEntity.ok("Message published successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}*/
	
	@PostMapping
	public ResponseEntity<?> publishMessage(@RequestBody Consumer consumer) {
		try {
			//for (int i = 0; i < 10000; i++) {
				kafkaMessagePublisher.sendMessage(consumer);
			//}
			return ResponseEntity.ok("Message published successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
