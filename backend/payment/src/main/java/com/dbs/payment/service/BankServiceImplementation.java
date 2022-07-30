package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.payment.dao.BankRepository;
import com.dbs.payment.dto.BankDTO;
import com.dbs.payment.exception.BankNotFoundException;
import com.dbs.payment.model.Bank;

@Service
public class BankServiceImplementation implements BankService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BankRepository bankRepository;
	@Override
	public List<BankDTO> getBank() {
		return bankRepository.findAll().stream().map(bank -> modelMapper.map(bank, BankDTO.class))
				.collect(Collectors.toList());
	
	}

	@Override
	public BankDTO getBankById(String bankId) throws BankNotFoundException {
		Optional<Bank> res = bankRepository.findById(bankId);
		if(res.isEmpty())
			throw new BankNotFoundException("Invalid bank id - "+bankId);
		BankDTO bankDTO = modelMapper.map(res.get(), BankDTO.class);
		return bankDTO;
	}

	@Override
	public String saveBank(BankDTO bankDTO) {
		Bank bank = modelMapper.map(bankDTO, Bank.class);
		bankRepository.save(bank);
		return "sucessfully saved bank details";
	}

	@Override
	public String deleteBankById(String bankId) throws BankNotFoundException {
		BankDTO bankDTO = getBankById(bankId) ;
		Bank bank = modelMapper.map(bankDTO, Bank.class) ;
		bankRepository.delete(bank) ;
		return "Successfully deleted bank with id :"+bankId;
	}

}
