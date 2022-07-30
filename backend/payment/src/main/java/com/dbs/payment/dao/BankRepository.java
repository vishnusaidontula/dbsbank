package com.dbs.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Bank;

public interface BankRepository extends JpaRepository<Bank, String> {

}
