package com.example.demo.message;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepo;
import com.example.demo.api.SentimentApi;
import com.example.demo.message.TransactionPublisher;
import com.example.demo.api.response.ScoreResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class TransactionListener {

	private TransactionRepo transactionRepo;
	private ObjectMapper objectMapper;
	private TransactionPublisher publisher;
	private SentimentApi sentimentApi;

	@JmsListener(destination = "transactionListener", containerFactory = "queueConnectionFactory")
	public void processMessage(String content) {
		try {
			log.info("Processing: " + content);
			var transaction = objectMapper.readValue(content, Transaction.class);

			ScoreResponse scoreResponse = sentimentApi.scoreText(transaction.getDescription());
			if (scoreResponse.getType().equals("negative")) {
				publisher.send(transaction);
				log.info("***Reporting***");
			}

			transactionRepo.save(transaction);
		} catch (Exception e) {
			log.error("Error occurred while processing message: " + e);
		}
	}
}