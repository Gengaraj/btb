package com.stc.api.btb.user;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stc.api.btb.appreciation.Appreciation;

@Entity
@Table(name = "USR_MST")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1392088522624338899L;

	public User() {
		// TODO Auto-generated constructor stub
	}

	// `ID` bigint(15) NOT NULL AUTO_INCREMENT,
	@Id
	@Column(name = "ID", length = 15)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private Long id;

	// `USER_NAME` varchar(15) NOT NULL DEFAULT '',
	@Column(name = "USER_NAME", nullable = false, length = 15)
	private String userName;

	// `USER_FIRST_NAME` varchar(500) NOT NULL,
	@Column(name = "USER_FIRST_NAME", nullable = false, length = 500)
	private String userFirstName;

	// `USER_MIDDLE_NAME` varchar(500) DEFAULT NULL,
	@Column(name = "USER_MIDDLE_NAME", length = 500)
	private String middleName;

	// `USER_LAST_NAME` varchar(500) DEFAULT NULL,
	@Column(name = "USER_LAST_NAME", nullable = false, length = 500)
	private String userLastName;

	// `USER_PHONE_NO` int(10) DEFAULT NULL,
	@Column(name = "USER_PHONE_NUM", length = 10)
	private Long phoneNumber;

	// `USER_PHONE_NO_EXT` int(10) DEFAULT NULL,
	@Column(name = "USER_PHONE_NUM_EXT", length = 10)
	private int phoneNumberExtn;

	// `USER_MOBILE_NO` int(10) DEFAULT NULL,
	@Column(name = "USER_MOBILE_NUM", length = 10)
	private Integer mobileNumber;

	// `USER_EMAIL_ID` varchar(75) NOT NULL,
	@Column(name = "USER_EMAIL_ID", nullable = false, length = 75)
	private String email;

	// `USER_DOB` datetime NOT NULL,
	//@Temporal(TemporalType.DATE)
	@Column(name = "USER_DOB", nullable = false)
	private Date dataOfBirth;

	// `USER_ADDR_STREET_1` varchar(500) DEFAULT NULL,
	@Column(name = "USER_ADDR_STREET_1", length = 500,columnDefinition="Address Street 1")
	private String addressStreet_1;

	// `USER_ADDR_STREET_2` varchar(500) DEFAULT NULL,
	@Column(name = "USER_ADDR_STREET_2", length = 500)
	private String addressStreet_2;

	// `USER_ADDR_CITY` varchar(25) DEFAULT NULL,
	@Column(name = "USER_ADDR_CITY", length = 25)
	private String addressCity;

	// `USER_ADDR_STATE_PROV` varchar(25) DEFAULT NULL,
	@Column(name = "USER_ADDR_STATE_PROV", length = 25)
	private String stateOrProvince;

	// `USER_ADDR_COUNTRY` varchar(25) DEFAULT NULL,
	@Column(name = "USER_ADDR_COUNTRY", length = 25)
	private String addressCountry;

	// `USER_ADDR_ZIP` int(10) DEFAULT NULL,
	@Column(name = "USER_ADDR_ZIP", length = 10)
	private int addressZip;

	// `USER_CREATED_BY` bigint(15) NOT NULL,
	@Column(name = "USER_CREATED_BY", nullable = false)
	private Long createdBy;

	/*@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_CREATED_BY",insertable=false,updatable=false,referencedColumnName="ID")
	private User createdByUser;*/

	// `USER_CREATED_ON` datetime NOT NULL,
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USER_CREATED_ON", nullable = false)
	private Timestamp createdOn;

	// `USER_STATUS` varchar(1) NOT NULL,
	@Column(name = "USER_STATUS", nullable = false, length = 1)
	private char userStatus;

	// `USER_UPDATED_BY` bigint(15) NOT NULL,
	@Column(name = "USER_UPDATED_BY", nullable = false)
	private Long updatedBy;

	/*@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_UPDATED_BY",insertable=false,updatable=false,referencedColumnName="ID")
	private User updatedByUser;*/

	// `USER_UPDATED_ON` datetime NOT NULL,
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USER_UPDATED_ON", nullable = false)
	private Timestamp updatedOn;

	// `USER_DELETED_ON` datetime DEFAULT NULL,
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USER_DELETED_ON")
	private Timestamp deletedOn;

	// `USER_DELETED_BY` bigint(15) DEFAULT NULL,
	@Column(name = "USER_DELETED_BY",insertable=false,updatable=false)
	private Long deletedBy;

	/*@OneToOne
	@JoinColumn(name = "USER_DELETED_BY")
	private User deletedByUser;*/

	// `USER_SSO_ID` varchar(30) NOT NULL DEFAULT '',
	@Column(name = "USER_SSO_ID", nullable = false, length = 30,columnDefinition="SSO Keycloak ID")
	private String ssoId;
	
	@OneToMany(targetEntity=Appreciation.class,mappedBy="givenTo",fetch=FetchType.EAGER)
	private List<Appreciation> appreciations;
	
	@OneToMany(targetEntity=Appreciation.class,mappedBy="givenBy",fetch=FetchType.EAGER)
	private List<Appreciation> appreciationsGiven;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneNumberExtn() {
		return phoneNumberExtn;
	}

	public void setPhoneNumberExtn(int phoneNumberExtn) {
		this.phoneNumberExtn = phoneNumberExtn;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(Date dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	public String getAddressStreet_1() {
		return addressStreet_1;
	}

	public void setAddressStreet_1(String addressStreet_1) {
		this.addressStreet_1 = addressStreet_1;
	}

	public String getAddressStreet_2() {
		return addressStreet_2;
	}

	public void setAddressStreet_2(String addressStreet_2) {
		this.addressStreet_2 = addressStreet_2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public int getAddressZip() {
		return addressZip;
	}

	public void setAddressZip(int addressZip) {
		this.addressZip = addressZip;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/*public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}*/

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public char getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(char userStatus) {
		this.userStatus = userStatus;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/*public User getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(User updatedByUser) {
		this.updatedByUser = updatedByUser;
	}*/

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Timestamp getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(Timestamp deletedOn) {
		this.deletedOn = deletedOn;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}

	/*public User getDeletedByUser() {
		return deletedByUser;
	}

	public void setDeletedByUser(User deletedByUser) {
		this.deletedByUser = deletedByUser;
	}*/

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public List<Appreciation> getAppreciations() {
		return appreciations;
	}

	public void setAppreciations(List<Appreciation> appreciations) {
		this.appreciations = appreciations;
	}

	public List<Appreciation> getAppreciationsGiven() {
		return appreciationsGiven;
	}

	public void setAppreciationsGiven(List<Appreciation> appreciationsGiven) {
		this.appreciationsGiven = appreciationsGiven;
	}

}
