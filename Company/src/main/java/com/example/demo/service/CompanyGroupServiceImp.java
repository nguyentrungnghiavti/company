package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CountByGroupResponse;
import com.example.demo.repository.CompanyGroupRepository;

@Service
public class CompanyGroupServiceImp {
//	
	@Autowired
	private  CompanyGroupRepository companyGroupRepository;


	public List<CountByGroupResponse> countCompanyByGroup(){
		
		List<Object[]> groupList = companyGroupRepository.getGroupTotalCompanies();
		
		List<CountByGroupResponse> responses = new ArrayList<>();
		
		for (Object[] object : groupList) {
			
			CountByGroupResponse countByGroupResponse = new CountByGroupResponse();
			countByGroupResponse.setGroupId((Integer)object[0]);
			countByGroupResponse.setGroupName((String)object[1]);
			countByGroupResponse.setCount((long)object[2]);
			
			responses.add(countByGroupResponse);
			
		}
	
		return responses;
		
	}
//

}
