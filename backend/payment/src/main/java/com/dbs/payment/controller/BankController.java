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

import com.dbs.payment.dto.BankDTO;
import com.dbs.payment.exception.BankNotFoundException;
import com.dbs.payment.service.BankService;

@CrossOrigin("*")
@RestController
public class BankController {
	@Autowired
	private BankService bankService;
	
	@GetMapping("/banks")
	public  ResponseEntity<List<BankDTO>> getBank() {
		List<BankDTO> banks = bankService.getBank();
			
		return ResponseEntity.ok().body(banks);
	}
		
	@GetMapping("/bank/{bankId}")
	public  ResponseEntity<BankDTO> getBankById(@PathVariable String bankId) throws BankNotFoundException {
		BankDTO bank = bankService.getBankById(bankId);
			
		return ResponseEntity.ok().body(bank);
	}
	@PostMapping("/bank")
	public ResponseEntity<String> saveBank(@RequestBody @Valid BankDTO bankDTO) {
			
		String responses = bankService.saveBank(bankDTO);
		return new ResponseEntity<String>(responses,HttpStatus.CREATED);
	}
		
	@DeleteMapping("/bank/{bankId}")
	public ResponseEntity<String> deleteBank(@PathVariable String bankId) throws BankNotFoundException {
		String response = bankService.deleteBankById(bankId);
		return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
	}
}
