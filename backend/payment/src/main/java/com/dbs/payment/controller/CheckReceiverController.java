package com.dbs.payment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payment.service.CheckReceiverService;
@CrossOrigin("*")
@RestController
public class CheckReceiverController {
	@Autowired
	private CheckReceiverService checkReceiverService;
	
	@GetMapping("/checkreceiver/{name}")
	public ResponseEntity<String> checkReceiverName(@PathVariable String name) throws IOException
	{
		return checkReceiverService.checkReceiverName(name)?ResponseEntity.ok().body("Transaction Not Allowed"):ResponseEntity.ok().body("Transaction Allowed");
	}
}
