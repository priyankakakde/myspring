package com.anubhavtrainings.demo.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

//import java.util.Date;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="vendor")
public class Vendor {
	
	@Id
	@Column(nullable=false, name="id")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Column(nullable=false, name="company_name")
	private String companyName;
	@Column(nullable=false, name="contactPerson")
	private String contactPerson;
	@Column(nullable=false, name="firstName")
	private String firstName;
	@Column(nullable=false, name="lastName")
	private String lastName;
	@Column(nullable=false, name="website")
	private String website;
	@Column(nullable=false, name="email")
	private String email;
	@Column(nullable=false, name="status")
	private String status;
	@Column(nullable=false, name="regDate")
	private Date regDate;
	public Vendor() {
		super();
		this.code = "VEND1";
		this.companyName = "IBM Incorporation";
		this.contactPerson = "Simon Smith";
		this.firstName = "Laura";
		this.lastName = "Simpson";
		this.website = "www.ibm.co.us";
		this.email = "laura@ibm.com";
		this.status = "A";
		this.regDate = new Date(0);
	}
	
	public Vendor(String code, String companyName, String contactPerson, String firstName, String lastName,
			String website, String email, String status, Date regDate) {
		super();
		this.code = code;
		this.companyName = companyName;
		this.contactPerson = contactPerson;
		this.firstName = firstName;
		this.lastName = lastName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "Vendor [code=" + code + ", companyName=" + companyName + ", contactPerson=" + contactPerson
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", website=" + website + ", email=" + email
				+ ", status=" + status + ", regDate=" + regDate + "]";
	}

	
	
}
