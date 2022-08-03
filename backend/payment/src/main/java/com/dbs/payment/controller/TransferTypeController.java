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

import com.dbs.payment.dto.TransferTypeDTO;
import com.dbs.payment.exception.TransferTypeNotFoundException;
import com.dbs.payment.service.TransferTypeService;
@CrossOrigin("*")
@RestController
public class TransferTypeController {
	@Autowired
	private TransferTypeService transferService;
	@GetMapping("/transfertype")
	public ResponseEntity<List<TransferTypeDTO>> getTransferType(){
		return ResponseEntity.ok(transferService.getTransferType());
	}
	@GetMapping("/transferType/{code}")
	public  ResponseEntity<TransferTypeDTO> getTransferTypeByCode(@PathVariable String code) throws TransferTypeNotFoundException {
		TransferTypeDTO transferTypeDto = transferService.getTransferTypeByCode(code);
		
		return ResponseEntity.ok(transferTypeDto);
	}
	@PostMapping("/transferType")
	public ResponseEntity<String> saveTransferType(@RequestBody @Valid TransferTypeDTO transferTypeDTO) {
		
		String response = transferService.saveTransferType(transferTypeDTO);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	@DeleteMapping("/transferType/{code}")
	public ResponseEntity<String> deleteTransferType(@PathVariable String code) throws TransferTypeNotFoundException {
		String response = transferService.deleteTransferTypeByCode(code);
		return new ResponseEntity<String>(response,HttpStatus.NO_CONTENT);
	}
}



