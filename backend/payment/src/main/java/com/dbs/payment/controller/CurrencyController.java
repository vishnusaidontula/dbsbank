package com.dbs.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.CurrencyDTO;
import com.dbs.payment.exception.CurrencyNotFoundException;
import com.dbs.payment.service.CurrencyService ;


@RestController
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;

		
	@GetMapping("/currency/{currencyCode}")
	public  ResponseEntity<CurrencyDTO> getCustomer(@PathVariable String currencyCode) throws CurrencyNotFoundException {
		CurrencyDTO currency = currencyService.getCurrencyByCode(currencyCode);
			
		return ResponseEntity.ok().body(currency);
	}
	@PostMapping("/currency")
	public String saveCurrency(@RequestBody @Valid CurrencyDTO currencyDTO) {
			
		String responses = currencyService.saveCurrency(currencyDTO);
		return responses;
	}
		
	@DeleteMapping("/currency/{currencyCode}")
	public String deleteCurency(@PathVariable String currencyCode) throws CurrencyNotFoundException {
		String response = currencyService.deleteCurrencyByCode(currencyCode);
		return response;
	}
}
