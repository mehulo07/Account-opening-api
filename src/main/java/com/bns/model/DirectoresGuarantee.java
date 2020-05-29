package com.bns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_Opening_Directors_Guarantee")
public class DirectoresGuarantee implements Serializable{

	/**
	 * @author mehul
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name="Account_Opening_Directors_Guarantee_id" , nullable = false ,length = 100 )
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long  guaranteeId; 
		
		@Column(name="inserted_on")
		private Date insertedOn;
		
		@Column(name="Name_of_Guarantor" , nullable = false ,length = 100 )
		private String guarantorName;
		
		@Column(name="guarantor_sign" , nullable = false ,length = 35 )
		private String guarantorSign;
		
		@Column(name="Name_of_Witness" , nullable = false , length = 100)
		private String witnessName;
		
		@Column(name="witness_sign" , nullable = false ,length = 100 )
		private String witnessSign;
		
		@Column(name="Witness_postcode" , nullable = false ,length = 35 )
		private String witnessPostcode;
		
		@Column(name="Witness_home_address" , nullable = false ,length = 35 )
		private String witnessHomeAddress;
		
		@Column(name="Witness_city" , nullable = false ,length = 35 )
		private String witnesscity;
		
		@Column(name="Witness_state" , nullable = false ,length = 35 )
		private String witnessState;
		
		@Column(name="Witness_country" , nullable = false ,length = 35 )
		private String witnessCountry;
		
		@Column(name="account_Opening_Business_Info_id" , nullable = false ,length = 8 )
		private int businessInfoId;
		
		
		public DirectoresGuarantee() {

		}

		public DirectoresGuarantee(Long guaranteeId, Date insertedOn, String guarantorName, String guarantorSign,
				String witnessName, String witnessSign, String witnessPostcode, String witnessHomeAddress,
				String witnesscity, String witnessState, String witnessCountry, int businessInfoId) {
			super();
			this.guaranteeId = guaranteeId;
			this.insertedOn = insertedOn;
			this.guarantorName = guarantorName;
			this.guarantorSign = guarantorSign;
			this.witnessName = witnessName;
			this.witnessSign = witnessSign;
			this.witnessPostcode = witnessPostcode;
			this.witnessHomeAddress = witnessHomeAddress;
			this.witnesscity = witnesscity;
			this.witnessState = witnessState;
			this.witnessCountry = witnessCountry;
			this.businessInfoId = businessInfoId;
		}



		public Long getGuaranteeId() {
			return guaranteeId;
		}

		public void setGuaranteeId(Long guaranteeId) {
			this.guaranteeId = guaranteeId;
		}

		public Date getInsertedOn() {
			return insertedOn;
		}

		public void setInsertedOn(Date insertedOn) {
			this.insertedOn = insertedOn;
		}

		public String getGuarantorName() {
			return guarantorName;
		}

		public void setGuarantorName(String guarantorName) {
			this.guarantorName = guarantorName;
		}

		public String getGuarantorSign() {
			return guarantorSign;
		}

		public void setGuarantorSign(String guarantorSign) {
			this.guarantorSign = guarantorSign;
		}

		public String getWitnessName() {
			return witnessName;
		}

		public void setWitnessName(String witnessName) {
			this.witnessName = witnessName;
		}

		public String getWitnessSign() {
			return witnessSign;
		}

		public void setWitnessSign(String witnessSign) {
			this.witnessSign = witnessSign;
		}

		public String getWitnessPostcode() {
			return witnessPostcode;
		}

		public void setWitnessPostcode(String witnessPostcode) {
			this.witnessPostcode = witnessPostcode;
		}

		public String getWitnessHomeAddress() {
			return witnessHomeAddress;
		}

		public void setWitnessHomeAddress(String witnessHomeAddress) {
			this.witnessHomeAddress = witnessHomeAddress;
		}

		public String getWitnesscity() {
			return witnesscity;
		}

		public void setWitnesscity(String witnesscity) {
			this.witnesscity = witnesscity;
		}

		public String getWitnessState() {
			return witnessState;
		}

		public void setWitnessState(String witnessState) {
			this.witnessState = witnessState;
		}

		public String getWitnessCountry() {
			return witnessCountry;
		}

		public void setWitnessCountry(String witnessCountry) {
			this.witnessCountry = witnessCountry;
		}

		public int getBusinessInfoId() {
			return businessInfoId;
		}

		public void setBusinessInfoId(int businessInfoId) {
			this.businessInfoId = businessInfoId;
		}

		@Override
		public String toString() {
			return "DirectoresGuarantee [guaranteeId=" + guaranteeId + ", insertedOn=" + insertedOn + ", guarantorName="
					+ guarantorName + ", guarantorSign=" + guarantorSign + ", witnessName=" + witnessName
					+ ", witnessSign=" + witnessSign + ", witnessPostcode=" + witnessPostcode + ", witnessHomeAddress="
					+ witnessHomeAddress + ", witnesscity=" + witnesscity + ", witnessState=" + witnessState
					+ ", witnessCountry=" + witnessCountry + ", businessInfoId=" + businessInfoId + "]";
		}
}
