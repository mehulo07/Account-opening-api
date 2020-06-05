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
@Table(name = "acc_opening_market_pref_tab" , schema = "ifsapp")
public class MarketingPref implements Serializable  {
	
	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;
	
	@Id
    @Column(name = "acc_opening_market_pref_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  accountOpeningMarketingPrefId;
	
    @Column(name = "marketing_Email",columnDefinition = "TINYINT(1)")
	private Boolean marketingEmail;
    
    @Column(name = "marketing_SMS",columnDefinition = "TINYINT(1)")
   	private Boolean marketingSMS;
    
    @Column(name = "marketing_Phone",columnDefinition = "TINYINT(1)")
   	private Boolean marketingPhone;
    
    @Column(name = "marketing_Post",columnDefinition = "TINYINT(1)")
   	private Boolean marketingPost;
    
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Registration.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "ao_pening_Reg_Info_id",columnDefinition="int(15)")
    private Registration accOpeningReg;
    
    

	public MarketingPref() {
	
		// TODO Auto-generated constructor stub
	}

	public MarketingPref(Long accountOpeningMarketingPrefId, Boolean marketingEmail, Boolean marketingSMS,
			Boolean marketingPhone, Boolean marketingPost, Registration accOpeningReg) {
		
		this.accountOpeningMarketingPrefId = accountOpeningMarketingPrefId;
		this.marketingEmail = marketingEmail;
		this.marketingSMS = marketingSMS;
		this.marketingPhone = marketingPhone;
		this.marketingPost = marketingPost;
		this.accOpeningReg = accOpeningReg;
	}

	public Long getAccountOpeningMarketingPrefId() {
		return accountOpeningMarketingPrefId;
	}

	public void setAccountOpeningMarketingPrefId(Long accountOpeningMarketingPrefId) {
		this.accountOpeningMarketingPrefId = accountOpeningMarketingPrefId;
	}

	public Boolean getMarketingEmail() {
		return marketingEmail;
	}

	public void setMarketingEmail(Boolean marketingEmail) {
		this.marketingEmail = marketingEmail;
	}

	public Boolean getMarketingSMS() {
		return marketingSMS;
	}

	public void setMarketingSMS(Boolean marketingSMS) {
		this.marketingSMS = marketingSMS;
	}

	public Boolean getMarketingPhone() {
		return marketingPhone;
	}

	public void setMarketingPhone(Boolean marketingPhone) {
		this.marketingPhone = marketingPhone;
	}

	public Boolean getMarketingPost() {
		return marketingPost;
	}

	public void setMarketingPost(Boolean marketingPost) {
		this.marketingPost = marketingPost;
	}

	public Registration getAccOpeningReg() {
		return accOpeningReg;
	}

	public void setAccOpeningReg(Registration accOpeningReg) {
		this.accOpeningReg = accOpeningReg;
	}

	@Override
	public String toString() {
		return "AccountOpeningMarketingPref [accountOpeningMarketingPrefId=" + accountOpeningMarketingPrefId
				+ ", marketingEmail=" + marketingEmail + ", marketingSMS=" + marketingSMS + ", marketingPhone="
				+ marketingPhone + ", marketingPost=" + marketingPost + ", accOpeningReg=" + accOpeningReg + "]";
	}
    
    
    


}
