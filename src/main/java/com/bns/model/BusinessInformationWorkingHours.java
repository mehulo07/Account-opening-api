package com.bns.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "business_Information_Working_Hours")
public class BusinessInformationWorkingHours implements Serializable {
	/**
	 * @author Hussain Doctor
	 */

	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "licence_Information_Details_Two_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long licenceInformationDetailsTwoId;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_Opening_Business_Info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;

	@Column(name = "working_Hours_Comment", length = 200)
	private String workingHoursComment;

	@Column(name = "mon_Opening_Hours", length = 45)
	private String monOpeningHours;

	@Column(name = "tue_Opening_Hours", length = 45)
	private String tueOpeningHours;
	@Column(name = "wed_Opening_Hours", length = 45)
	private String wedOpeningHours;
	@Column(name = "thu_Opening_Hours", length = 45)
	private String thuOpeningHours;
	@Column(name = "fri_Opening_Hours", length = 45)
	private String friOpeningHours;
	@Column(name = "sat_Opening_Hours", length = 45)
	private String satOpeningHours;
	
	
	@Column(name = "mon_close_Hours", length = 45)
	private String moncloseHours;

	@Column(name = "tue_Close_Hours", length = 45)
	private String tueCloseHours;
	@Column(name = "wed_Close_Hours", length = 45)
	private String wedCloseHours;
	@Column(name = "thu_Close_Hours", length = 45)
	private String thuCloseHours;
	@Column(name = "fri_Close_Hours", length = 45)
	private String friCloseHours;
	@Column(name = "sat_Close_Hours", length = 45)
	private String satCloseHours;
	
	@Column(name = "term_Condition", columnDefinition = "TINYINT(1)")
	private Boolean termCondition;

	public BusinessInformationWorkingHours() {
		
		// TODO Auto-generated constructor stub
	}

	public BusinessInformationWorkingHours(Long licenceInformationDetailsTwoId,
			BusinessInfo accountOpeningBusinessInfo, String workingHoursComment, String monOpeningHours,
			String tueOpeningHours, String wedOpeningHours, String thuOpeningHours, String friOpeningHours,
			String satOpeningHours, String moncloseHours, String tueCloseHours, String wedCloseHours,
			String thuCloseHours, String friCloseHours, String satCloseHours, Boolean termCondition) {
		super();
		this.licenceInformationDetailsTwoId = licenceInformationDetailsTwoId;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
		this.workingHoursComment = workingHoursComment;
		this.monOpeningHours = monOpeningHours;
		this.tueOpeningHours = tueOpeningHours;
		this.wedOpeningHours = wedOpeningHours;
		this.thuOpeningHours = thuOpeningHours;
		this.friOpeningHours = friOpeningHours;
		this.satOpeningHours = satOpeningHours;
		this.moncloseHours = moncloseHours;
		this.tueCloseHours = tueCloseHours;
		this.wedCloseHours = wedCloseHours;
		this.thuCloseHours = thuCloseHours;
		this.friCloseHours = friCloseHours;
		this.satCloseHours = satCloseHours;
		this.termCondition = termCondition;
	}

	public Long getLicenceInformationDetailsTwoId() {
		return licenceInformationDetailsTwoId;
	}

	public void setLicenceInformationDetailsTwoId(Long licenceInformationDetailsTwoId) {
		this.licenceInformationDetailsTwoId = licenceInformationDetailsTwoId;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public String getWorkingHoursComment() {
		return workingHoursComment;
	}

	public void setWorkingHoursComment(String workingHoursComment) {
		this.workingHoursComment = workingHoursComment;
	}

	public String getMonOpeningHours() {
		return monOpeningHours;
	}

	public void setMonOpeningHours(String monOpeningHours) {
		this.monOpeningHours = monOpeningHours;
	}

	public String getTueOpeningHours() {
		return tueOpeningHours;
	}

	public void setTueOpeningHours(String tueOpeningHours) {
		this.tueOpeningHours = tueOpeningHours;
	}

	public String getWedOpeningHours() {
		return wedOpeningHours;
	}

	public void setWedOpeningHours(String wedOpeningHours) {
		this.wedOpeningHours = wedOpeningHours;
	}

	public String getThuOpeningHours() {
		return thuOpeningHours;
	}

	public void setThuOpeningHours(String thuOpeningHours) {
		this.thuOpeningHours = thuOpeningHours;
	}

	public String getFriOpeningHours() {
		return friOpeningHours;
	}

	public void setFriOpeningHours(String friOpeningHours) {
		this.friOpeningHours = friOpeningHours;
	}

	public String getSatOpeningHours() {
		return satOpeningHours;
	}

	public void setSatOpeningHours(String satOpeningHours) {
		this.satOpeningHours = satOpeningHours;
	}

	public String getMoncloseHours() {
		return moncloseHours;
	}

	public void setMoncloseHours(String moncloseHours) {
		this.moncloseHours = moncloseHours;
	}

	public String getTueCloseHours() {
		return tueCloseHours;
	}

	public void setTueCloseHours(String tueCloseHours) {
		this.tueCloseHours = tueCloseHours;
	}

	public String getWedCloseHours() {
		return wedCloseHours;
	}

	public void setWedCloseHours(String wedCloseHours) {
		this.wedCloseHours = wedCloseHours;
	}

	public String getThuCloseHours() {
		return thuCloseHours;
	}

	public void setThuCloseHours(String thuCloseHours) {
		this.thuCloseHours = thuCloseHours;
	}

	public String getFriCloseHours() {
		return friCloseHours;
	}

	public void setFriCloseHours(String friCloseHours) {
		this.friCloseHours = friCloseHours;
	}

	public String getSatCloseHours() {
		return satCloseHours;
	}

	public void setSatCloseHours(String satCloseHours) {
		this.satCloseHours = satCloseHours;
	}

	public Boolean getTermCondition() {
		return termCondition;
	}

	public void setTermCondition(Boolean termCondition) {
		this.termCondition = termCondition;
	}

	@Override
	public String toString() {
		return "BusinessInformationWorkingHours [licenceInformationDetailsTwoId=" + licenceInformationDetailsTwoId
				+ ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + ", workingHoursComment="
				+ workingHoursComment + ", monOpeningHours=" + monOpeningHours + ", tueOpeningHours=" + tueOpeningHours
				+ ", wedOpeningHours=" + wedOpeningHours + ", thuOpeningHours=" + thuOpeningHours + ", friOpeningHours="
				+ friOpeningHours + ", satOpeningHours=" + satOpeningHours + ", moncloseHours=" + moncloseHours
				+ ", tueCloseHours=" + tueCloseHours + ", wedCloseHours=" + wedCloseHours + ", thuCloseHours="
				+ thuCloseHours + ", friCloseHours=" + friCloseHours + ", satCloseHours=" + satCloseHours
				+ ", termCondition=" + termCondition + "]";
	}
	
	
	
	
	

}
