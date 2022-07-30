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

import com.dbs.payment.dto.BankDTO;
import com.dbs.payment.exception.BankNotFoundException;
import com.dbs.payment.service.BankService;

@RestController
public class BankController {
	@Autowired
	private BankService bankService;

		
	@GetMapping("/bank/{bankId}")
	public  ResponseEntity<BankDTO> getBank(@PathVariable String bankId) throws BankNotFoundException {
		BankDTO bank = bankService.getBankById(bankId);
			
		return ResponseEntity.ok().body(bank);
	}
	@PostMapping("/bank")
	public String saveBank(@RequestBody @Valid BankDTO bankDTO) {
			
		String responses = bankService.saveBank(bankDTO);
		return responses;
	}
		
	@DeleteMapping("/bank/{bankId}")
	public String deleteBank(@PathVariable String bankId) throws BankNotFoundException {
		String response = bankService.deleteBankById(bankId);
		return response;
	}
}
