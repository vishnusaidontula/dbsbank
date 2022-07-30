package com.dbs.payment.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.dbs.payment.model.TransferType;

public interface TransferTypeRepository extends JpaRepository<TransferType,String> {
	

}
