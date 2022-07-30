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

import com.dbs.payment.dto.TransferTypeDTO;
import com.dbs.payment.exception.TransferTypeNotFoundException;
import com.dbs.payment.service.TransferService;

@RestController
public class TransferTypeController {
	@Autowired
	private TransferService transferService;
	@GetMapping("/transferType/{code}")
	public  ResponseEntity<TransferTypeDTO> getTransferType(@PathVariable String code) throws TransferTypeNotFoundException {
		TransferTypeDTO transferTypeDto = transferService.getTransferTypeByCode(code);
		
		return ResponseEntity.ok(transferTypeDto);
	}
	@PostMapping("/transferType")
	public String saveTransferType(@RequestBody @Valid TransferTypeDTO transferTypeDTO) {
		
		String responses = transferService.saveTransferType(transferTypeDTO);
		return responses;
	}
	@DeleteMapping("/transferType/{code}")
	public String deleteTransferType(@PathVariable String code) throws TransferTypeNotFoundException {
		String response = transferService.deleteTransferTypeByCode(code);
		return response;
	}
}



