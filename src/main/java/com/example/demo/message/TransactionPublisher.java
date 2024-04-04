package com.example.demo.message;

import com.example.demo.model.Transaction;
import com.example.demo.model.ReportedTransaction;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionPublisher {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper mapper;

    public void send(Transaction transaction) throws JsonProcessingException {
	ReportedTransaction txn = new ReportedTransaction(transaction.getTransactionId(), "This is the offensive description");
        jmsTemplate.convertAndSend("transactionReport", mapper.writeValueAsString(txn));
    }
}