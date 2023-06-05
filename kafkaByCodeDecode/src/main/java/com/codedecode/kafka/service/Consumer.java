package com.codedecode.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	 	
		@KafkaListener(topics="codeDecode_topic", groupId = "codeDecode_topic")
		public void listenToTopic(String receivedMsg) {
			System.out.println("receivedMsg: "+ receivedMsg);
			
		}
}
