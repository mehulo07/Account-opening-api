package com.bns.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "licence_Information_Details_Two" , schema = "ifsapp")
public class LicenceInformationDetailsTwo implements Serializable {

	/**
	 * @author Hussain Doctor
	 */

	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "licence_Information_Details_Two_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long licenceInformationDetailsTwoId;

	@Temporal(TemporalType.DATE)
	@Column(name = "ms_License_Releasing_Date")
	private Date msLicenseReleasingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ms_License_Expiry_Date")
	private Date msLicenseExpiryDate;

	@Column(name = "ms_Name_of_Issuing_Authority", length = 100)
	private String msNameofIssuingAuthority;

	@Column(name = "ms_Counrty_License_Issuing", length = 100)
	private String msCounrtyLicenseIssuing;

	@Column(name = "ms_No", columnDefinition = "TINYINT(1)")
	private Boolean msNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "gdp_License_Releasing_Date")
	private Date gdpLicenseReleasingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "gdp_License_Expiry_Date")
	private Date gdpLicenseExpiryDate;

	@Column(name = "gdp_Name_of_Issuing_Authority", length = 100)
	private String gdpNameofIssuingAuthority;

	@Column(name = "gdp_Counrty_License_Issuing", length = 100)
	private String gdpCounrtyLicenseIssuing;

	@Column(name = "gdp_No", columnDefinition = "TINYINT(1)")
	private Boolean gdpNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "gmp_License_Releasing_Date")
	private Date gmpLicenseReleasingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "gmp_License_Expiry_Date")
	private Date gmpLicenseExpiryDate;

	@Column(name = "gmp_Name_of_Issuing_Authority", length = 100)
	private String gmpNameofIssuingAuthority;

	@Column(name = "gmp_Counrty_License_Issuing", length = 100)
	private String gmpCounrtyLicenseIssuing;

	@Column(name = "gmp_No", columnDefinition = "TINYINT(1)")
	private Boolean gmpNo;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_Opening_Business_Info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;

	public LicenceInformationDetailsTwo() {

		// TODO Auto-generated constructor stub
	}

	public LicenceInformationDetailsTwo(Long licenceInformationDetailsTwoId, Date msLicenseReleasingDate,
			Date msLicenseExpiryDate, String msNameofIssuingAuthority, String msCounrtyLicenseIssuing, Boolean msNo,
			Date gdpLicenseReleasingDate, Date gdpLicenseExpiryDate, String gdpNameofIssuingAuthority,
			String gdpCounrtyLicenseIssuing, Boolean gdpNo, Date gmpLicenseReleasingDate, Date gmpLicenseExpiryDate,
			String gmpNameofIssuingAuthority, String gmpCounrtyLicenseIssuing, Boolean gmpNo,
			BusinessInfo accountOpeningBusinessInfo) {
		super();
		this.licenceInformationDetailsTwoId = licenceInformationDetailsTwoId;
		this.msLicenseReleasingDate = msLicenseReleasingDate;
		this.msLicenseExpiryDate = msLicenseExpiryDate;
		this.msNameofIssuingAuthority = msNameofIssuingAuthority;
		this.msCounrtyLicenseIssuing = msCounrtyLicenseIssuing;
		this.msNo = msNo;
		this.gdpLicenseReleasingDate = gdpLicenseReleasingDate;
		this.gdpLicenseExpiryDate = gdpLicenseExpiryDate;
		this.gdpNameofIssuingAuthority = gdpNameofIssuingAuthority;
		this.gdpCounrtyLicenseIssuing = gdpCounrtyLicenseIssuing;
		this.gdpNo = gdpNo;
		this.gmpLicenseReleasingDate = gmpLicenseReleasingDate;
		this.gmpLicenseExpiryDate = gmpLicenseExpiryDate;
		this.gmpNameofIssuingAuthority = gmpNameofIssuingAuthority;
		this.gmpCounrtyLicenseIssuing = gmpCounrtyLicenseIssuing;
		this.gmpNo = gmpNo;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public Long getLicenceInformationDetailsTwoId() {
		return licenceInformationDetailsTwoId;
	}

	public void setLicenceInformationDetailsTwoId(Long licenceInformationDetailsTwoId) {
		this.licenceInformationDetailsTwoId = licenceInformationDetailsTwoId;
	}

	public Date getMsLicenseReleasingDate() {
		return msLicenseReleasingDate;
	}

	public void setMsLicenseReleasingDate(Date msLicenseReleasingDate) {
		this.msLicenseReleasingDate = msLicenseReleasingDate;
	}

	public Date getMsLicenseExpiryDate() {
		return msLicenseExpiryDate;
	}

	public void setMsLicenseExpiryDate(Date msLicenseExpiryDate) {
		this.msLicenseExpiryDate = msLicenseExpiryDate;
	}

	public String getMsNameofIssuingAuthority() {
		return msNameofIssuingAuthority;
	}

	public void setMsNameofIssuingAuthority(String msNameofIssuingAuthority) {
		this.msNameofIssuingAuthority = msNameofIssuingAuthority;
	}

	public String getMsCounrtyLicenseIssuing() {
		return msCounrtyLicenseIssuing;
	}

	public void setMsCounrtyLicenseIssuing(String msCounrtyLicenseIssuing) {
		this.msCounrtyLicenseIssuing = msCounrtyLicenseIssuing;
	}

	public Boolean getMsNo() {
		return msNo;
	}

	public void setMsNo(Boolean msNo) {
		this.msNo = msNo;
	}

	public Date getGdpLicenseReleasingDate() {
		return gdpLicenseReleasingDate;
	}

	public void setGdpLicenseReleasingDate(Date gdpLicenseReleasingDate) {
		this.gdpLicenseReleasingDate = gdpLicenseReleasingDate;
	}

	public Date getGdpLicenseExpiryDate() {
		return gdpLicenseExpiryDate;
	}

	public void setGdpLicenseExpiryDate(Date gdpLicenseExpiryDate) {
		this.gdpLicenseExpiryDate = gdpLicenseExpiryDate;
	}

	public String getGdpNameofIssuingAuthority() {
		return gdpNameofIssuingAuthority;
	}

	public void setGdpNameofIssuingAuthority(String gdpNameofIssuingAuthority) {
		this.gdpNameofIssuingAuthority = gdpNameofIssuingAuthority;
	}

	public String getGdpCounrtyLicenseIssuing() {
		return gdpCounrtyLicenseIssuing;
	}

	public void setGdpCounrtyLicenseIssuing(String gdpCounrtyLicenseIssuing) {
		this.gdpCounrtyLicenseIssuing = gdpCounrtyLicenseIssuing;
	}

	public Boolean getGdpNo() {
		return gdpNo;
	}

	public void setGdpNo(Boolean gdpNo) {
		this.gdpNo = gdpNo;
	}

	public Date getGmpLicenseReleasingDate() {
		return gmpLicenseReleasingDate;
	}

	public void setGmpLicenseReleasingDate(Date gmpLicenseReleasingDate) {
		this.gmpLicenseReleasingDate = gmpLicenseReleasingDate;
	}

	public Date getGmpLicenseExpiryDate() {
		return gmpLicenseExpiryDate;
	}

	public void setGmpLicenseExpiryDate(Date gmpLicenseExpiryDate) {
		this.gmpLicenseExpiryDate = gmpLicenseExpiryDate;
	}

	public String getGmpNameofIssuingAuthority() {
		return gmpNameofIssuingAuthority;
	}

	public void setGmpNameofIssuingAuthority(String gmpNameofIssuingAuthority) {
		this.gmpNameofIssuingAuthority = gmpNameofIssuingAuthority;
	}

	public String getGmpCounrtyLicenseIssuing() {
		return gmpCounrtyLicenseIssuing;
	}

	public void setGmpCounrtyLicenseIssuing(String gmpCounrtyLicenseIssuing) {
		this.gmpCounrtyLicenseIssuing = gmpCounrtyLicenseIssuing;
	}

	public Boolean getGmpNo() {
		return gmpNo;
	}

	public void setGmpNo(Boolean gmpNo) {
		this.gmpNo = gmpNo;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	@Override
	public String toString() {
		return "LicenceInformationDetailsTwo [licenceInformationDetailsTwoId=" + licenceInformationDetailsTwoId
				+ ", msLicenseReleasingDate=" + msLicenseReleasingDate + ", msLicenseExpiryDate=" + msLicenseExpiryDate
				+ ", msNameofIssuingAuthority=" + msNameofIssuingAuthority + ", msCounrtyLicenseIssuing="
				+ msCounrtyLicenseIssuing + ", msNo=" + msNo + ", gdpLicenseReleasingDate=" + gdpLicenseReleasingDate
				+ ", gdpLicenseExpiryDate=" + gdpLicenseExpiryDate + ", gdpNameofIssuingAuthority="
				+ gdpNameofIssuingAuthority + ", gdpCounrtyLicenseIssuing=" + gdpCounrtyLicenseIssuing + ", gdpNo="
				+ gdpNo + ", gmpLicenseReleasingDate=" + gmpLicenseReleasingDate + ", gmpLicenseExpiryDate="
				+ gmpLicenseExpiryDate + ", gmpNameofIssuingAuthority=" + gmpNameofIssuingAuthority
				+ ", gmpCounrtyLicenseIssuing=" + gmpCounrtyLicenseIssuing + ", gmpNo=" + gmpNo
				+ ", accountOpeningBusinessInfo=" + accountOpeningBusinessInfo + "]";
	}

}
