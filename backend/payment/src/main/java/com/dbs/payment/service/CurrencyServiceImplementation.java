package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.payment.dao.CurrencyRepository;
import com.dbs.payment.dto.CurrencyDTO;
import com.dbs.payment.exception.CurrencyNotFoundException;
import com.dbs.payment.model.Currency;


@Service
public class CurrencyServiceImplementation implements CurrencyService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CurrencyRepository currencyRepository;
	@Override
	public List<CurrencyDTO> getCurrency() {
		return currencyRepository.findAll().stream().map(currency -> modelMapper.map(currency, CurrencyDTO.class))
				.collect(Collectors.toList());
	}
	@Override
	public CurrencyDTO getCurrencyByCode(String currencyCode) throws CurrencyNotFoundException {
		Optional<Currency> res = currencyRepository.findById(currencyCode);
		if(res.isEmpty())
			throw new CurrencyNotFoundException("Invalid currency code - "+currencyCode);
		CurrencyDTO currencyDTO = modelMapper.map(res.get(),CurrencyDTO.class);
		return currencyDTO;
	}
	@Override
	public String saveCurrency(CurrencyDTO currencyDTO) {
		Currency currency = modelMapper.map(currencyDTO, Currency.class);
		currencyRepository.save(currency);
		return "sucessfully saved currency details";
		
	}
	@Override
	public String deleteCurrencyByCode(String currencyCode) throws CurrencyNotFoundException {
		CurrencyDTO currencyDTO = getCurrencyByCode(currencyCode);
		Currency currency = modelMapper.map(currencyDTO, Currency.class);
		currencyRepository.delete(currency);
		return "sucessfully deleted currency with code - "+currencyCode;
		
	}
	
}
