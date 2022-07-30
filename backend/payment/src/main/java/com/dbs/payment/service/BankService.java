package com.dbs.payment.service;

import java.util.List;

import com.dbs.payment.dto.BankDTO;
import com.dbs.payment.exception.BankNotFoundException;

public interface BankService {
	public List<BankDTO> getBank();
	public BankDTO getBankById(String bankId) throws BankNotFoundException;
	public String saveBank(BankDTO bankDTO);
	public String deleteBankById(String bankId) throws BankNotFoundException ;
}
