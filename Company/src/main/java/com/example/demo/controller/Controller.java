package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CompanyResponse;
import com.example.demo.dto.CountByCityResponse;
import com.example.demo.dto.CountByGroupResponse;
import com.example.demo.service.AddressServiceImp;
import com.example.demo.service.CompanyGroupServiceImp;
import com.example.demo.service.CompanyServiceImp;

@RestController
@RequestMapping("/api/v1")
public class Controller {
	
	
	@Autowired
	private CompanyGroupServiceImp companyGroupServiceImp;
	
	@Autowired
	private AddressServiceImp addressServiceImp;
	
	@Autowired
	private CompanyServiceImp companyServiceImp;
	
	
	@GetMapping("/group/count")
	public List<CountByGroupResponse> getGroupTotalCompanies(){
		List<CountByGroupResponse> groupList = companyGroupServiceImp.countCompanyByGroup();
		return groupList;
		
	}
	

	@GetMapping("/city/count")
	public List<CountByCityResponse> getCityTotalCompanies(){
		List<CountByCityResponse> cityList = addressServiceImp.getCountCompanyByCity();
		return cityList;
		
	}
	
	@GetMapping("/branch")
	public List<CompanyResponse> getCompanyTotalBraches(){
		List<CompanyResponse> companies = companyServiceImp.getCompanies();
		return companies;
		
	}
	
	@GetMapping("/company")
	public List<Object[]> getCompaniesAnhBranches(){
		List<Object[]> companyList = companyServiceImp.getCompaniesAnhBranches();
		return companyList;
		
	}
	
	
}
