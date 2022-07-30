package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.MessageRepository;
import com.dbs.payment.dto.MessageDTO;

import com.dbs.payment.exception.MessageNotFoundException;
import com.dbs.payment.model.Message;
@Service
public class MessageServiceImplementation implements MessageService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private MessageRepository messageRepository;
	@Override
	public List<MessageDTO> getMessageCode() {
		return messageRepository.findAll().stream().map(message -> modelMapper.map(message,MessageDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public MessageDTO getMessageByCode(String code) throws MessageNotFoundException {
		Optional<Message> res = messageRepository.findById(code);
		if(res.isEmpty())
			throw new MessageNotFoundException("Invalid message code - "+code);
		MessageDTO messageDTO = modelMapper.map(res.get(), MessageDTO.class);
		return messageDTO;
	}

	@Override
	public String saveMessage(MessageDTO messageDTO) {
		Message message = modelMapper.map(messageDTO,Message.class);
		messageRepository.save(message);
		return "sucessfully saved Message";
	}

	@Override
	public String deleteMessageByCode(String code) throws MessageNotFoundException {
		MessageDTO messageDTO = getMessageByCode(code);
		Message message = modelMapper.map(messageDTO, Message.class);
		messageRepository.delete(message);
		return "sucessfully deleted message with code - "+code;
	}

}
