package com.codedecode.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMsgToPublic(String msg) {
		
		//codeDecode_topic is topic name and msg is message that need to be sent on that topic
		kafkaTemplate.send("codeDecode_topic",msg);
	}

}
