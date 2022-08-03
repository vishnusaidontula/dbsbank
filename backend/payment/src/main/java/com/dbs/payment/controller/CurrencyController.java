package com.dbs.payment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.dto.CurrencyDTO;
import com.dbs.payment.exception.CurrencyNotFoundException;
import com.dbs.payment.service.CurrencyService ;

@CrossOrigin("*")
@RestController
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;

	@GetMapping("/currency")
	public  ResponseEntity<List<CurrencyDTO>> getCurrency() throws CurrencyNotFoundException {
		return ResponseEntity.ok(currencyService.getCurrency());
	}
	
	@GetMapping("/currency/{currencyCode}")
	public  ResponseEntity<CurrencyDTO> getCurrencyByCode(@PathVariable String currencyCode) throws CurrencyNotFoundException {
		CurrencyDTO currency = currencyService.getCurrencyByCode(currencyCode);
		return ResponseEntity.ok(currency);
	}
	@PostMapping("/currency")
	public ResponseEntity<String> saveCurrency(@RequestBody @Valid CurrencyDTO currencyDTO) {
			
		String responses = currencyService.saveCurrency(currencyDTO);
		return new ResponseEntity<String>(responses,HttpStatus.CREATED);
	}
		
	@DeleteMapping("/currency/{currencyCode}")
	public ResponseEntity<String> deleteCurrency(@PathVariable String currencyCode) throws CurrencyNotFoundException {
		String response = currencyService.deleteCurrencyByCode(currencyCode);
		return new  ResponseEntity<String>(response,HttpStatus.NO_CONTENT);
	}
}
