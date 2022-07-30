package com.dbs.payment.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.payment.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
	
}
