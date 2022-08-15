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

import com.dbs.payment.dto.MessageDTO;
import com.dbs.payment.exception.MessageNotFoundException;
import com.dbs.payment.service.MessageService;


@CrossOrigin("*")
@RestController
public class MessageController {
	@Autowired
	private MessageService messageService;
	@GetMapping("/message")
	public ResponseEntity<List<MessageDTO>> getMessage(){
		return ResponseEntity.ok().body(messageService.getMessageCode());
	}
	@GetMapping("/message/{code}")
	public  ResponseEntity<MessageDTO> getMessageByCode(@PathVariable String code) throws MessageNotFoundException {
		MessageDTO message = messageService.getMessageByCode(code);
		
		return ResponseEntity.ok().body(message);
	}
	@PostMapping("/message")
	public ResponseEntity<String> saveMessage(@RequestBody @Valid MessageDTO messageDTO) {
		
		String responses = messageService.saveMessage(messageDTO);
		return new ResponseEntity<String>(responses,HttpStatus.CREATED);
	}
	@DeleteMapping("/message/{code}")
	public ResponseEntity<String> deleteMessage(@PathVariable String code) throws MessageNotFoundException {
		String response = messageService.deleteMessageByCode(code);
		return new ResponseEntity<String>(response,HttpStatus.NO_CONTENT);
	}
}
