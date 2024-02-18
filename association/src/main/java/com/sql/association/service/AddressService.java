package com.sql.association.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.association.model.Address;
import com.sql.association.respository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addrRepository;
	
	public List<Address> viewAddress() {
		return addrRepository.findAll();
	}

	public String deleteAddress(Long id) {
		addrRepository.deleteById(id);
		return "Deleted the address successfully";
	}

}
