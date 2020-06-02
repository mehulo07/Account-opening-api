package com.bns.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security_Question" , schema = "ifsapp")
public class SecurityQuestionMaster implements Serializable {
	
	/**
	 * @author Hussain Doctor
	 */
	
	private static final long serialVersionUID = 1298211974861057016L;

	@Id
    @Column(name = "security_Question_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  securityQuestionId;
	
    @Column(name = "security_Question_Name", nullable = false,length = 100)
	private String securityQuestionName;
    
    
	public SecurityQuestionMaster() {
		
	}
	
	
	public SecurityQuestionMaster(Long  securityQuestionId, String securityQuestionName) {
		this.securityQuestionId = securityQuestionId;
		this.securityQuestionName = securityQuestionName;
	}


	public Long  getSecurityQuestionId() {
		return securityQuestionId;
	}
	public void setSecurityQuestionId(Long  securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}
	public String getSecurityQuestionName() {
		return securityQuestionName;
	}
	public void setSecurityQuestionName(String securityQuestionName) {
		this.securityQuestionName = securityQuestionName;
	}
	
	@Override
	public String toString() {
		return "security_Question [securityQuestionId=" + securityQuestionId + ", securityQuestionName=" + securityQuestionName + "]";
	}
	
	
	
	

}
