package com.dbs.payment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payment.dao.TransferTypeRepository;

import com.dbs.payment.dto.TransferTypeDTO;

import com.dbs.payment.exception.TransferTypeNotFoundException;

import com.dbs.payment.model.TransferType;
@Service
public class TranferTypeServiceImplementation implements TransferTypeService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private TransferTypeRepository transferTypeRepository;
	@Override
	public List<TransferTypeDTO> getTransferType() {
		return transferTypeRepository.findAll().stream().map(transferType -> modelMapper.map(transferType,TransferTypeDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public TransferTypeDTO getTransferTypeByCode(String code) throws TransferTypeNotFoundException {
		Optional<TransferType> res = transferTypeRepository.findById(code);
		if(res.isEmpty())
			throw new TransferTypeNotFoundException("Invalid transfer type - "+code);
		TransferTypeDTO transferTypeDTO = modelMapper.map(res.get(), TransferTypeDTO.class);
		return transferTypeDTO;
	}

	@Override
	public String saveTransferType(TransferTypeDTO transferTypeDTO) {
		TransferType transferType = modelMapper.map(transferTypeDTO,TransferType.class);
		transferTypeRepository.save(transferType);
		return "sucessfully saved Message";
		
	}

	@Override
	public String deleteTransferTypeByCode(String code) throws TransferTypeNotFoundException {
		TransferTypeDTO transferTypeDTO = getTransferTypeByCode(code);
		TransferType transferType = modelMapper.map(transferTypeDTO, TransferType.class);
		transferTypeRepository.delete(transferType);
		return "sucessfully deleted TransferType with code - "+code;
	}

}
