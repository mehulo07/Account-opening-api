package com.bns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name="acc_opening_cust_fin_decl_tab")
@RequestMapping("/v1/openAccount")
public class FinalDeclaration implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="acc_opening_cust_fin_decl_id" , length = 8)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long declarationId;
	
	@Column(name="propiretors_date" , nullable = false)
	private Date propiretorsDate;
	
	@Column(name="Propiretors_Name" , nullable = false , length = 35)
	private String propiretorsName;
	
	@Column(name="Propiretors_Sign" , nullable = false , length = 35)
	private String propiretorsSign;

	@Column(name="representative_Date" , nullable = false)
	private Date representativeDate;
	
	@Column(name="bns_Representative_Name" , nullable = false , length = 35)
	private String representativeName;
		
	@Column(name="bns_Representative_Sign" , nullable = false , length = 35)
	private String representativeSign;
	
	@Column(name = "TERM_CONDITION" , nullable = false , length = 1 ,columnDefinition = "TINYINT(1)")
	private Boolean termCondition;
	
	@Column(name="acc_opening_busi_info_id" , nullable = false ,length = 8 )
	private int businessInfoId;

	public FinalDeclaration() {

	}

	public FinalDeclaration(Long declarationId, Date propiretorsDate, String propiretorsName, String propiretorsSign,
			Date representativeDate, String representativeName, String representativeSign, Boolean termCondition,
			int businessInfoId) {
		this.declarationId = declarationId;
		this.propiretorsDate = propiretorsDate;
		this.propiretorsName = propiretorsName;
		this.propiretorsSign = propiretorsSign;
		this.representativeDate = representativeDate;
		this.representativeName = representativeName;
		this.representativeSign = representativeSign;
		this.termCondition = termCondition;
		this.businessInfoId = businessInfoId;
	}

	public Long getDeclarationId() {
		return declarationId;
	}

	public void setDeclarationId(Long declarationId) {
		this.declarationId = declarationId;
	}

	public Date getPropiretorsDate() {
		return propiretorsDate;
	}

	public void setPropiretorsDate(Date propiretorsDate) {
		this.propiretorsDate = propiretorsDate;
	}

	public String getPropiretorsName() {
		return propiretorsName;
	}

	public void setPropiretorsName(String propiretorsName) {
		this.propiretorsName = propiretorsName;
	}

	public String getPropiretorsSign() {
		return propiretorsSign;
	}

	public void setPropiretorsSign(String propiretorsSign) {
		this.propiretorsSign = propiretorsSign;
	}

	public Date getRepresentativeDate() {
		return representativeDate;
	}

	public void setRepresentativeDate(Date representativeDate) {
		this.representativeDate = representativeDate;
	}

	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}

	public String getRepresentativeSign() {
		return representativeSign;
	}

	public void setRepresentativeSign(String representativeSign) {
		this.representativeSign = representativeSign;
	}

	public Boolean getTermCondition() {
		return termCondition;
	}

	public void setTermCondition(Boolean termCondition) {
		this.termCondition = termCondition;
	}

	public int getBusinessInfoId() {
		return businessInfoId;
	}

	public void setBusinessInfoId(int businessInfoId) {
		this.businessInfoId = businessInfoId;
	}

	@Override
	public String toString() {
		return "FinalDeclaration [declarationId=" + declarationId + ", propiretorsDate=" + propiretorsDate
				+ ", propiretorsName=" + propiretorsName + ", propiretorsSign=" + propiretorsSign
				+ ", representativeDate=" + representativeDate + ", representativeName=" + representativeName
				+ ", representativeSign=" + representativeSign + ", termCondition=" + termCondition
				+ ", businessInfoId=" + businessInfoId + "]";
	}
	
}
