package com.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ActiveMqApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(ActiveMqApplication.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.convertAndSend("SecondMessage", "Hello World from Command Line Runner!");
		logger.info("My Second message has been published to the ActiveMQ!");
	}

}
