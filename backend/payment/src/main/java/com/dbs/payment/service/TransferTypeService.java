package com.dbs.payment.service;

import java.util.List;



import com.dbs.payment.dto.TransferTypeDTO;
import com.dbs.payment.exception.TransferTypeNotFoundException;


public interface TransferTypeService {
	public List<TransferTypeDTO> getTransferType();
	public TransferTypeDTO getTransferTypeByCode(String code) throws TransferTypeNotFoundException;
	public String saveTransferType(TransferTypeDTO transferType);
	public String deleteTransferTypeByCode(String code) throws TransferTypeNotFoundException;
}
