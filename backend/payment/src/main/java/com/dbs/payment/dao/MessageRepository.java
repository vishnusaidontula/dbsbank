package com.dbs.payment.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Message;

public interface MessageRepository extends JpaRepository<Message,String> {
}
