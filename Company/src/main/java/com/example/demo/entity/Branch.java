package com.example.demo.entity;

import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "branch")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private String branchCode;
	private String fax;
	private String phoneNo;
	private String email;
	@ManyToOne
	private Address addressId;
	private Timestamp createOn;
	private Timestamp lastUpdate;
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JsonIgnore
	    @JoinColumn(name = "company_id",referencedColumnName = "company_id")
	    private Company company;
}
