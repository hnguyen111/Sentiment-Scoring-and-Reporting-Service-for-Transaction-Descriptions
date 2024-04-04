package com.example.demo.repository;

import com.example.demo.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TransactionRepo extends CrudRepository<Transaction, String> {

}