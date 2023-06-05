package com.codedecode.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.kafka.service.Producer;

@RestController
@RequestMapping("/api/v1")
public class KafkaController {
	
	@Autowired
	private Producer producer;
	
	@GetMapping("/producerMsg")
	public void getMsgFromClient(@RequestParam("msg") String msg) {
			producer.sendMsgToPublic(msg);
	}
	

}
