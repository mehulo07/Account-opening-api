package com.bns.model;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class RegistrationUserDetails implements UserDetails{

	private int accountOpeningRegInfoId;

	private String firstName;

	private String surName;

	private String regPosition;

	private String regPharmacyName;

	private String regContactNoType;

	private String regContactNo;
	private String regWebSite;

	private String regEmailAddress;

	private String regPassword;

	private boolean regTermCondition;

	private Date regCreateDate;

	private Date regUpdateDate;

	public RegistrationUserDetails() {
		
		// TODO Auto-generated constructor stub
	}

	public RegistrationUserDetails(Registration reg) {
		
		this.accountOpeningRegInfoId = reg.getAccountOpeningRegInfoId();
		this.firstName = reg.getFirstName();
		this.surName = reg.getSurName();
		this.regPosition = reg.getRegPosition();
		this.regPharmacyName = reg.getRegPharmacyName();
		this.regContactNoType = reg.getRegContactNoType();
		this.regContactNo = reg.getRegContactNo();
		this.regWebSite = reg.getRegWebSite();
		this.regEmailAddress = reg.getRegEmailAddress();
		this.regPassword = reg.getRegPassword();
		this.regTermCondition = reg.isRegTermCondition();
		this.regCreateDate = reg.getRegCreateDate();
		this.regUpdateDate = reg.getRegUpdateDate();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return regPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return regEmailAddress;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

		
	
	

}
