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
@Table(name = "account_Opening_security_Que")
public class AccountOpeningSecurityQue implements Serializable {
	

	@Id
    @Column(name = "account_Opening_security_Que_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  accountOpeningSecurityQueId;
	
    @Column(name = "security_Question_One", nullable = false,length = 200)
	private String securityQuestionOne;
    
    @Column(name = "security_Answer_One", nullable = false,length = 200)
   	private String securityAnswerOne;
    
    @Column(name = "security_Question_Two", nullable = false,length = 200)
   	private String securityQuestionTwo;
    
    @Column(name = "security_Answer_Two", nullable = false,length = 200)
   	private String securityAnswerTwo;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ao_pening_Reg_Info_id", referencedColumnName = "accountOpeningRegInfoId")
    @OneToOne(fetch = FetchType.EAGER, targetEntity = AccOpeningReg.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ao_pening_Reg_Info_id",columnDefinition="int(15)")
    private AccOpeningReg accOpeningReg;
    
    @Column(name = "security_term_condition",columnDefinition = "TINYINT(1)")
   	private Boolean securityTermCondition;

	public AccountOpeningSecurityQue() {
		
			}

	public AccountOpeningSecurityQue(Long accountOpeningSecurityQueId, String securityQuestionOne,
			String securityAnswerOne, String securityQuestionTwo, String securityAnswerTwo, AccOpeningReg accOpeningReg,
			Boolean securityTermCondition) {
		
		this.accountOpeningSecurityQueId = accountOpeningSecurityQueId;
		this.securityQuestionOne = securityQuestionOne;
		this.securityAnswerOne = securityAnswerOne;
		this.securityQuestionTwo = securityQuestionTwo;
		this.securityAnswerTwo = securityAnswerTwo;
		this.accOpeningReg = accOpeningReg;
		this.securityTermCondition = securityTermCondition;
	}

	public Long getAccountOpeningSecurityQueId() {
		return accountOpeningSecurityQueId;
	}

	public void setAccountOpeningSecurityQueId(Long accountOpeningSecurityQueId) {
		this.accountOpeningSecurityQueId = accountOpeningSecurityQueId;
	}

	public String getSecurityQuestionOne() {
		return securityQuestionOne;
	}

	public void setSecurityQuestionOne(String securityQuestionOne) {
		this.securityQuestionOne = securityQuestionOne;
	}

	public String getSecurityAnswerOne() {
		return securityAnswerOne;
	}

	public void setSecurityAnswerOne(String securityAnswerOne) {
		this.securityAnswerOne = securityAnswerOne;
	}

	public String getSecurityQuestionTwo() {
		return securityQuestionTwo;
	}

	public void setSecurityQuestionTwo(String securityQuestionTwo) {
		this.securityQuestionTwo = securityQuestionTwo;
	}

	public String getSecurityAnswerTwo() {
		return securityAnswerTwo;
	}

	public void setSecurityAnswerTwo(String securityAnswerTwo) {
		this.securityAnswerTwo = securityAnswerTwo;
	}

	public AccOpeningReg getAccOpeningReg() {
		return accOpeningReg;
	}

	public void setAccOpeningReg(AccOpeningReg accOpeningReg) {
		this.accOpeningReg = accOpeningReg;
	}

	public Boolean getSecurityTermCondition() {
		return securityTermCondition;
	}

	public void setSecurityTermCondition(Boolean securityTermCondition) {
		this.securityTermCondition = securityTermCondition;
	}

	@Override
	public String toString() {
		return "AccountOpeningSecurityQue [accountOpeningSecurityQueId=" + accountOpeningSecurityQueId
				+ ", securityQuestionOne=" + securityQuestionOne + ", securityAnswerOne=" + securityAnswerOne
				+ ", securityQuestionTwo=" + securityQuestionTwo + ", securityAnswerTwo=" + securityAnswerTwo
				+ ", accOpeningReg=" + accOpeningReg + ", securityTermCondition=" + securityTermCondition + "]";
	}
	
	
    
    
    
    
}
