package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	
	 @Query("SELECT a.city, COUNT(c) " +
	           "FROM Address a " +
	           "LEFT JOIN Company c ON a.addressId = c.addressId.addressId " +
	           "GROUP BY a.addressId, a.city")
		    List<Object[]> getAddressTotalCompanies();
	

}
