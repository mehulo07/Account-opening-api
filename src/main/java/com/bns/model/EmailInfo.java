package com.bns.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bns.utility.BooleanToStringConverter;

@Entity
@Table(name="acc_opening_email_info_tab" , schema = "ifsapp")
public class EmailInfo implements Serializable {

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = -4206417867112122310L;

	@Id
	@Column(name="acc_opening_email_info_id")
	@GeneratedValue()
	private Long accountOpeningEmailInfoId;
	
	@Column(name="email_verified")
	@Convert(converter=BooleanToStringConverter.class)
	private boolean emailVerified = false;
	
	@OneToOne(cascade =CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name="account_opening_reg_info_id", referencedColumnName="acc_opening_reg_info_id")
	private Registration accOpeningReg;
	
	
	public EmailInfo() {
	}

	public EmailInfo(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Long getAccountOpeningEmailInfoId() {
		return accountOpeningEmailInfoId;
	}

	public void setAccountOpeningEmailInfoId(Long accountOpeningEmailInfoId) {
		this.accountOpeningEmailInfoId = accountOpeningEmailInfoId;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Registration getAccOpeningReg() {
		return accOpeningReg;
	}

	public void setAccOpeningReg(Registration accOpeningReg) {
		this.accOpeningReg = accOpeningReg;
	}
	
}
