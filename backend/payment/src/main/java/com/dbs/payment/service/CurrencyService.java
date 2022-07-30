package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.dto.CurrencyDTO;
import com.dbs.payment.exception.CurrencyNotFoundException;

public interface CurrencyService {
	public List<CurrencyDTO> getCurrency();
	public CurrencyDTO getCurrencyByCode(String currencyCode) throws CurrencyNotFoundException;
	public String saveCurrency(CurrencyDTO currencyDTO);
	public String deleteCurrencyByCode(String currencyCode) throws CurrencyNotFoundException ;
}
