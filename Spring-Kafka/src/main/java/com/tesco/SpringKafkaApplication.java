package com.tesco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaApplication {

	public static class KafkaMessageProducer {
		@Autowired
		public KafkaTemplate<String, String> kafkaTemplate;
		@Autowired
		public KafkaTemplate<String, User> userKafkaTemplate;
		@Value(value = "${test.topic.name}")
		public String topicName;
		@Value(value = "${user.topic.name}")
		public String userTopicName;

		public void sendMessage(String message) {
			kafkaTemplate.send(topicName, message);
		}

		public void sendUserMessage(User user) {
			userKafkaTemplate.send(userTopicName, user);
		}
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringKafkaApplication.class, args);
		KafkaMessageProducer producer = context.getBean(KafkaMessageProducer.class);

		producer.sendMessage("This is a message for test topic");
		producer.sendUserMessage(new User("1", "Gopal", "Pattanaik"));
	    //context.close();
	}

	// Producers
	@Bean
	public KafkaMessageProducer kafkaMessageProducer() {
		return new KafkaMessageProducer();
	}

	// Kafka Listner for test topic
	@KafkaListener(topics = "${test.topic.name}", groupId = "KafkaListner")
	public void listen(String message) {
		System.out.println("Received Messasge : " + message);
	}

	// Listner for user topic
	@KafkaListener(topics = "${user.topic.name}", containerFactory = "userKafkaListenerContainerFactory")
	public void userListener(User user) {
		System.out.println("Received Messasge for user: " + user);
	}
}
