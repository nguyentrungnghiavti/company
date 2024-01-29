package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CountByCityResponse;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressServiceImp {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public List<CountByCityResponse> getCountCompanyByCity(){
		List<Object[]> cityList = addressRepository.getAddressTotalCompanies();
		
		List<CountByCityResponse> responses = new ArrayList<>();
		
		for (Object[] object : cityList) {
			CountByCityResponse cityResponse = new CountByCityResponse();
			cityResponse.setCityName((String)object[0]);
			cityResponse.setCount((long)object[1]);
			responses.add(cityResponse);
		}
		return responses;
		
	}
}
