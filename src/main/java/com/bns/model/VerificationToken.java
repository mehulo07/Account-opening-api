package com.bns.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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


@Entity
@Table(name = "verification_token_tab", schema = "ifsapp")
public class VerificationToken implements Serializable {

	/**
	 * @author Hussain Doctor
	 */

	private static final long serialVersionUID = 1298211974861057016L;

	@Id
	@Column(name = "verification_token_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long verificationTokenTabId;

	@Column(name = "temp_token", nullable = false, length = 100)
	private String tempToken;

	
	@Column(name = "exp_token")
	private LocalDateTime expToken;

	
	@Column(name = "create_token")
	private LocalDateTime createToken;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = Registration.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ao_pening_Reg_Info_id", columnDefinition = "int(15)")
	private Registration accOpeningReg;

	public VerificationToken() {

		// TODO Auto-generated constructor stub
	}

	public VerificationToken(Long verificationTokenTabId, String tempToken, LocalDateTime expToken,
			LocalDateTime createToken, Registration accOpeningReg) {
		super();
		this.verificationTokenTabId = verificationTokenTabId;
		this.tempToken = tempToken;
		this.expToken = expToken;
		this.createToken = createToken;
		this.accOpeningReg = accOpeningReg;
	}

	public Long getVerificationTokenTabId() {
		return verificationTokenTabId;
	}

	public void setVerificationTokenTabId(Long verificationTokenTabId) {
		this.verificationTokenTabId = verificationTokenTabId;
	}

	public String getTempToken() {
		return tempToken;
	}

	public void setTempToken(String tempToken) {
		this.tempToken = tempToken;
	}

	public LocalDateTime getExpToken() {
		return expToken;
	}

	public void setExpToken(LocalDateTime expToken) {
		this.expToken = expToken;
	}

	public LocalDateTime getCreateToken() {
		return createToken;
	}

	public void setCreateToken(LocalDateTime createToken) {
		this.createToken = createToken;
	}

	public Registration getAccOpeningReg() {
		return accOpeningReg;
	}

	public void setAccOpeningReg(Registration accOpeningReg) {
		this.accOpeningReg = accOpeningReg;
	}

	@Override
	public String toString() {
		return "VerificationToken [verificationTokenTabId=" + verificationTokenTabId + ", tempToken=" + tempToken
				+ ", expToken=" + expToken + ", createToken=" + createToken + ", accOpeningReg=" + accOpeningReg + "]";
	}
	
	

			
}
