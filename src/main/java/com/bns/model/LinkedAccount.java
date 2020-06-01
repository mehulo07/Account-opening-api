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
@Table(name="account_Opening_Linked_Acc")
public class LinkedAccount implements Serializable{

	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "account_Opening_Linked_Acc_id",nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  accountOpeningLinkedAccId;
	
    @Column(name = "web_Ordering",columnDefinition = "TINYINT(1)")
	private Boolean webOrdering;
    
    @Column(name = "tender_Ordering",columnDefinition = "TINYINT(1)")
   	private Boolean tenderOrdering;
    
    @Column(name = "specials_Ordering",columnDefinition = "TINYINT(1)")
   	private Boolean specialsOrdering;
    
    @Column(name = "new_linked_Accounts", nullable = false,length = 100)
   	private String newlinkedAccounts;
    
    @Column(name = "old_Account_Number", nullable = false,length = 100)
   	private String oldAccountNumber;
    
    @Column(name = "acc_comments", nullable = false,length = 200)
   	private String acccomments;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Registration.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ao_pening_Reg_Info_id",columnDefinition="int(15)",nullable = false)
    private Registration accOpeningReg;

    
    
	public LinkedAccount() {
		
		// TODO Auto-generated constructor stub
	}



	public LinkedAccount(Long accountOpeningLinkedAccId, Boolean webOrdering, Boolean tenderOrdering,
			Boolean specialsOrdering, String newlinkedAccounts, String oldAccountNumber, String acccomments,
			Registration accOpeningReg) {
		super();
		this.accountOpeningLinkedAccId = accountOpeningLinkedAccId;
		this.webOrdering = webOrdering;
		this.tenderOrdering = tenderOrdering;
		this.specialsOrdering = specialsOrdering;
		this.newlinkedAccounts = newlinkedAccounts;
		this.oldAccountNumber = oldAccountNumber;
		this.acccomments = acccomments;
		this.accOpeningReg = accOpeningReg;
	}



	public Long getAccountOpeningLinkedAccId() {
		return accountOpeningLinkedAccId;
	}



	public void setAccountOpeningLinkedAccId(Long accountOpeningLinkedAccId) {
		this.accountOpeningLinkedAccId = accountOpeningLinkedAccId;
	}



	public Boolean getWebOrdering() {
		return webOrdering;
	}



	public void setWebOrdering(Boolean webOrdering) {
		this.webOrdering = webOrdering;
	}



	public Boolean getTenderOrdering() {
		return tenderOrdering;
	}



	public void setTenderOrdering(Boolean tenderOrdering) {
		this.tenderOrdering = tenderOrdering;
	}



	public Boolean getSpecialsOrdering() {
		return specialsOrdering;
	}



	public void setSpecialsOrdering(Boolean specialsOrdering) {
		this.specialsOrdering = specialsOrdering;
	}



	public String getNewlinkedAccounts() {
		return newlinkedAccounts;
	}



	public void setNewlinkedAccounts(String newlinkedAccounts) {
		this.newlinkedAccounts = newlinkedAccounts;
	}



	public String getOldAccountNumber() {
		return oldAccountNumber;
	}



	public void setOldAccountNumber(String oldAccountNumber) {
		this.oldAccountNumber = oldAccountNumber;
	}



	public String getAcccomments() {
		return acccomments;
	}



	public void setAcccomments(String acccomments) {
		this.acccomments = acccomments;
	}



	public Registration getAccOpeningReg() {
		return accOpeningReg;
	}



	public void setAccOpeningReg(Registration accOpeningReg) {
		this.accOpeningReg = accOpeningReg;
	}



	@Override
	public String toString() {
		return "AccountOpeningLinkedAcc [accountOpeningLinkedAccId=" + accountOpeningLinkedAccId + ", webOrdering="
				+ webOrdering + ", tenderOrdering=" + tenderOrdering + ", specialsOrdering=" + specialsOrdering
				+ ", newlinkedAccounts=" + newlinkedAccounts + ", oldAccountNumber=" + oldAccountNumber
				+ ", acccomments=" + acccomments + ", accOpeningReg=" + accOpeningReg + "]";
	}

		
    
    

	
}
