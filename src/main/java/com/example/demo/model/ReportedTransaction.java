package com.example.demo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReportedTransaction {
	private String transactionId;
	private String description;

	public ReportedTransaction (String transactionId, String description) {
		this.transactionId = transactionId;
		this.description = description;
	}
}