package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CompanyGroup;


public interface CompanyGroupRepository extends JpaRepository<CompanyGroup, Integer> {
	
	
    @Query("SELECT g.groupId, g.groupName, COUNT(c) " +
           "FROM CompanyGroup g " +
           "LEFT JOIN Company c ON g.groupId = c.groupId.groupId " +
           "GROUP BY g.groupId, g.groupName")
	    List<Object[]> getGroupTotalCompanies();

}
