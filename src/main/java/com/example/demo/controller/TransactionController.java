package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepo;
import com.example.demo.api.SentimentApi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransactionController {

	private TransactionRepo transactionRepo;
	
	private SentimentApi sentimentApi;

	@GetMapping("/transaction")
	public Iterable<Transaction> getTransactions() {
		return transactionRepo.findAll();
	}

	@PostMapping("/transaction/score")
	public float scoreTransaction(@RequestBody Transaction transaction) {
		return sentimentApi.scoreText(transaction.getDescription()).getScore();
	}

	@PostMapping("/transaction/clean")
	public Transaction cleanTransaction(@RequestBody Transaction transaction) {
		transaction.setDescription(sentimentApi.sanitiseString(transaction.getDescription()).getText());
		return transaction;
	}
}