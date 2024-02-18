package com.sql.association.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sql.association.model.Address;
import com.sql.association.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	AddressService addrService;
	
	@GetMapping("/view_address")
	public List<Address> getAllAddress() {
		return addrService.viewAddress();
	}
	
	@DeleteMapping("/delete_address")
	public String deleteAddress(@RequestParam Long id) {
		return addrService.deleteAddress(id);
	}
}
