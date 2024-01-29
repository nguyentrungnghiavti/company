package com.example.demo.entity;
import java.security.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "company")
public class Company {
	@Id
	@Column(name = "company_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	@ManyToOne
	private CompanyGroup groupId;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
	private List<Branch> branches;
	private String companyName;
	@ManyToOne
	private Address addressId;
	private Timestamp createOn;
	private Timestamp lastUpdate;
	
	
}
