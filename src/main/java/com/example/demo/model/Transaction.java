package com.example.demo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transaction {
	private String transactionId;
	private String fromAccount;
	private String toAccount;
	private BigDecimal amount;
	private String description;
}