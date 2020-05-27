package com.bns.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Company_Type")
public class CompanyType implements Serializable{
	

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;

	@Id
    @Column(name = "company_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  companyId;
	
    @Column(name = "company_name", nullable = false,length = 100)
	private String companyName;


    
    public CompanyType() {
		
	}

	public CompanyType(Long companyId, String companyName) {
		this.companyId = companyId;
		this.companyName = companyName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "CompanyType [companyId=" + companyId + ", companyName=" + companyName + "]";
	}
	
	

    
    

}
