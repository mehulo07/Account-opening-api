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
@Table(name = "lic_info_details_one_tab" , schema = "ifsapp")
public class LicenceInformationDetailsOne implements Serializable {

	/**
	 * @author Hussain Doctor
	 */

	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "lic_info_details_one_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long licenceInformationDetailsOneId;

	@Temporal(TemporalType.DATE)
	@Column(name = "wda_License_Releasing_Date")
	private Date wdaLicenseReleasingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "wda_License_Expiry_Date")
	private Date wdaLicenseExpiryDate;

	@Column(name = "wda_Name_of_Issuing_Authority", length = 100)
	private String wdaNameofIssuingAuthority;

	@Column(name = "wda_Counrty_License_Issuing", length = 100)
	private String wdaCounrtyLicenseIssuing;

	@Column(name = "wda_No", columnDefinition = "TINYINT(1)")
	private Boolean wdaNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "cds_License_Releasing_Date")
	private Date cdsLicenseReleasingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "cds_License_Expiry_Date")
	private Date cdsLicenseExpiryDate;

	@Column(name = "cds_Name_of_Issuing_Authority", length = 100)
	private String cdsNameofIssuingAuthority;

	@Column(name = "cds_Counrty_License_Issuing", length = 100)
	private String cdsCounrtyLicenseIssuing;

	@Column(name = "cds_No", columnDefinition = "TINYINT(1)")
	private Boolean cdsNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "ma_License_Releasing_Date")
	private Date maLicenseReleasingDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ma_License_Expiry_Date")
	private Date maLicenseExpiryDate;

	@Column(name = "ma_Name_of_Issuing_Authority", length = 100)
	private String maNameofIssuingAuthority;

	@Column(name = "ma_Counrty_License_Issuing", length = 100)
	private String maCounrtyLicenseIssuing;

	@Column(name = "ma_No", columnDefinition = "TINYINT(1)")
	private Boolean maNo;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = BusinessInfo.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_opening_busi_info_id", columnDefinition = "int(15)", nullable = false)
	private BusinessInfo accountOpeningBusinessInfo;

	public LicenceInformationDetailsOne() {

		// TODO Auto-generated constructor stub
	}

	public LicenceInformationDetailsOne(Long licenceInformationDetailsOneId, Date wdaLicenseReleasingDate,
			Date wdaLicenseExpiryDate, String wdaNameofIssuingAuthority, String wdaCounrtyLicenseIssuing, Boolean wdaNo,
			Date cdsLicenseReleasingDate, Date cdsLicenseExpiryDate, String cdsNameofIssuingAuthority,
			String cdsCounrtyLicenseIssuing, Boolean cdsNo, Date maLicenseReleasingDate, Date maLicenseExpiryDate,
			String maNameofIssuingAuthority, String maCounrtyLicenseIssuing, Boolean maNo,
			BusinessInfo accountOpeningBusinessInfo) {
		super();
		this.licenceInformationDetailsOneId = licenceInformationDetailsOneId;
		this.wdaLicenseReleasingDate = wdaLicenseReleasingDate;
		this.wdaLicenseExpiryDate = wdaLicenseExpiryDate;
		this.wdaNameofIssuingAuthority = wdaNameofIssuingAuthority;
		this.wdaCounrtyLicenseIssuing = wdaCounrtyLicenseIssuing;
		this.wdaNo = wdaNo;
		this.cdsLicenseReleasingDate = cdsLicenseReleasingDate;
		this.cdsLicenseExpiryDate = cdsLicenseExpiryDate;
		this.cdsNameofIssuingAuthority = cdsNameofIssuingAuthority;
		this.cdsCounrtyLicenseIssuing = cdsCounrtyLicenseIssuing;
		this.cdsNo = cdsNo;
		this.maLicenseReleasingDate = maLicenseReleasingDate;
		this.maLicenseExpiryDate = maLicenseExpiryDate;
		this.maNameofIssuingAuthority = maNameofIssuingAuthority;
		this.maCounrtyLicenseIssuing = maCounrtyLicenseIssuing;
		this.maNo = maNo;
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	public Long getLicenceInformationDetailsOneId() {
		return licenceInformationDetailsOneId;
	}

	public void setLicenceInformationDetailsOneId(Long licenceInformationDetailsOneId) {
		this.licenceInformationDetailsOneId = licenceInformationDetailsOneId;
	}

	public Date getWdaLicenseReleasingDate() {
		return wdaLicenseReleasingDate;
	}

	public void setWdaLicenseReleasingDate(Date wdaLicenseReleasingDate) {
		this.wdaLicenseReleasingDate = wdaLicenseReleasingDate;
	}

	public Date getWdaLicenseExpiryDate() {
		return wdaLicenseExpiryDate;
	}

	public void setWdaLicenseExpiryDate(Date wdaLicenseExpiryDate) {
		this.wdaLicenseExpiryDate = wdaLicenseExpiryDate;
	}

	public String getWdaNameofIssuingAuthority() {
		return wdaNameofIssuingAuthority;
	}

	public void setWdaNameofIssuingAuthority(String wdaNameofIssuingAuthority) {
		this.wdaNameofIssuingAuthority = wdaNameofIssuingAuthority;
	}

	public String getWdaCounrtyLicenseIssuing() {
		return wdaCounrtyLicenseIssuing;
	}

	public void setWdaCounrtyLicenseIssuing(String wdaCounrtyLicenseIssuing) {
		this.wdaCounrtyLicenseIssuing = wdaCounrtyLicenseIssuing;
	}

	public Boolean getWdaNo() {
		return wdaNo;
	}

	public void setWdaNo(Boolean wdaNo) {
		this.wdaNo = wdaNo;
	}

	public Date getCdsLicenseReleasingDate() {
		return cdsLicenseReleasingDate;
	}

	public void setCdsLicenseReleasingDate(Date cdsLicenseReleasingDate) {
		this.cdsLicenseReleasingDate = cdsLicenseReleasingDate;
	}

	public Date getCdsLicenseExpiryDate() {
		return cdsLicenseExpiryDate;
	}

	public void setCdsLicenseExpiryDate(Date cdsLicenseExpiryDate) {
		this.cdsLicenseExpiryDate = cdsLicenseExpiryDate;
	}

	public String getCdsNameofIssuingAuthority() {
		return cdsNameofIssuingAuthority;
	}

	public void setCdsNameofIssuingAuthority(String cdsNameofIssuingAuthority) {
		this.cdsNameofIssuingAuthority = cdsNameofIssuingAuthority;
	}

	public String getCdsCounrtyLicenseIssuing() {
		return cdsCounrtyLicenseIssuing;
	}

	public void setCdsCounrtyLicenseIssuing(String cdsCounrtyLicenseIssuing) {
		this.cdsCounrtyLicenseIssuing = cdsCounrtyLicenseIssuing;
	}

	public Boolean getCdsNo() {
		return cdsNo;
	}

	public void setCdsNo(Boolean cdsNo) {
		this.cdsNo = cdsNo;
	}

	public Date getMaLicenseReleasingDate() {
		return maLicenseReleasingDate;
	}

	public void setMaLicenseReleasingDate(Date maLicenseReleasingDate) {
		this.maLicenseReleasingDate = maLicenseReleasingDate;
	}

	public Date getMaLicenseExpiryDate() {
		return maLicenseExpiryDate;
	}

	public void setMaLicenseExpiryDate(Date maLicenseExpiryDate) {
		this.maLicenseExpiryDate = maLicenseExpiryDate;
	}

	public String getMaNameofIssuingAuthority() {
		return maNameofIssuingAuthority;
	}

	public void setMaNameofIssuingAuthority(String maNameofIssuingAuthority) {
		this.maNameofIssuingAuthority = maNameofIssuingAuthority;
	}

	public String getMaCounrtyLicenseIssuing() {
		return maCounrtyLicenseIssuing;
	}

	public void setMaCounrtyLicenseIssuing(String maCounrtyLicenseIssuing) {
		this.maCounrtyLicenseIssuing = maCounrtyLicenseIssuing;
	}

	public Boolean getMaNo() {
		return maNo;
	}

	public void setMaNo(Boolean maNo) {
		this.maNo = maNo;
	}

	public BusinessInfo getAccountOpeningBusinessInfo() {
		return accountOpeningBusinessInfo;
	}

	public void setAccountOpeningBusinessInfo(BusinessInfo accountOpeningBusinessInfo) {
		this.accountOpeningBusinessInfo = accountOpeningBusinessInfo;
	}

	@Override
	public String toString() {
		return "LicenceInformationDetailsOne [licenceInformationDetailsOneId=" + licenceInformationDetailsOneId
				+ ", wdaLicenseReleasingDate=" + wdaLicenseReleasingDate + ", wdaLicenseExpiryDate="
				+ wdaLicenseExpiryDate + ", wdaNameofIssuingAuthority=" + wdaNameofIssuingAuthority
				+ ", wdaCounrtyLicenseIssuing=" + wdaCounrtyLicenseIssuing + ", wdaNo=" + wdaNo
				+ ", cdsLicenseReleasingDate=" + cdsLicenseReleasingDate + ", cdsLicenseExpiryDate="
				+ cdsLicenseExpiryDate + ", cdsNameofIssuingAuthority=" + cdsNameofIssuingAuthority
				+ ", cdsCounrtyLicenseIssuing=" + cdsCounrtyLicenseIssuing + ", cdsNo=" + cdsNo
				+ ", maLicenseReleasingDate=" + maLicenseReleasingDate + ", maLicenseExpiryDate=" + maLicenseExpiryDate
				+ ", maNameofIssuingAuthority=" + maNameofIssuingAuthority + ", maCounrtyLicenseIssuing="
				+ maCounrtyLicenseIssuing + ", maNo=" + maNo + ", accountOpeningBusinessInfo="
				+ accountOpeningBusinessInfo + "]";
	}

}
