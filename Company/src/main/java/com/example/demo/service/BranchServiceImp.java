package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.BranchRepository;

@Service
public class BranchServiceImp {
	
	@Autowired
	private BranchRepository branchRepository;
	
	
}
