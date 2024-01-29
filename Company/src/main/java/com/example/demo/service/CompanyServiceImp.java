package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CompanyResponse;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyServiceImp {

	@Autowired
	private CompanyRepository companyRepository;

	public List<CompanyResponse> getCompanies() {
		List<Company> companies = companyRepository.findAll();

		return companies.stream()
				.filter(company -> company.getBranches().size() >= 2)
				.map(company -> new CompanyResponse(company.getCompanyName(), company.getBranches().stream()
						.map(Branch::getBranchName)
						.collect(Collectors.toList())))
				.collect(Collectors.toList());
	}

	public List<Object[]> getCompaniesAnhBranches() {
		List<Object[]> companyList = companyRepository.getCompaniesAnhBranches();
		return companyList;

	}
}
