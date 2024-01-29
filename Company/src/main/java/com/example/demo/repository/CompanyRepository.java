package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	@Query("SELECT c " +
		       "FROM Company c " +
		       "JOIN Branch b ON c.companyId = b.company.companyId "  )
		List<Object[]> getCompaniesAnhBranches();
}
