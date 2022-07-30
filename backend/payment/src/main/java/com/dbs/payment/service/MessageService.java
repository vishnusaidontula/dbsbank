package com.dbs.payment.service;

import java.util.List;


import com.dbs.payment.dto.MessageDTO;
import com.dbs.payment.exception.MessageNotFoundException;


public interface MessageService {
	public List<MessageDTO> getMessageCode();
	public MessageDTO getMessageByCode(String code) throws MessageNotFoundException;
	public String saveMessage(MessageDTO message);
	public String deleteMessageByCode(String code) throws MessageNotFoundException;

}
