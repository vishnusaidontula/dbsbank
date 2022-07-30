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

import com.dbs.payment.dto.MessageDTO;
import com.dbs.payment.exception.CustomerNotFoundException;
import com.dbs.payment.exception.MessageNotFoundException;
import com.dbs.payment.service.MessageService;



@RestController
public class MessageController {
	@Autowired
	private MessageService messageService;
	@GetMapping("/message/{code}")
	public  ResponseEntity<MessageDTO> getMessage(@PathVariable String code) throws MessageNotFoundException {
		MessageDTO message = messageService.getMessageByCode(code);
		
		return ResponseEntity.ok().body(message);
	}
	@PostMapping("/message")
	public String saveCustomer(@RequestBody @Valid MessageDTO messageDTO) {
		
		String responses = messageService.saveMessage(messageDTO);
		return responses;
	}
	@DeleteMapping("/message/{code}")
	public String deleteMessage(@PathVariable String code) throws MessageNotFoundException {
		String response = messageService.deleteMessageByCode(code);
		return response;
	}
}
