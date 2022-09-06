package com.bagudu.appointSys.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.bagudu.appointSys.random.RandomString;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String username;//username = application ID
	
	private String mobileNum;
	
	private String password;//password = reference num
	
	private String email;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	private Appointment appointment;
	
	public String generatePassword() {		
		return RandomString.getAlphaNumericString(7);
	}
	
	public String generateUsername() {
		
		return RandomString.getAlphaNumericString(7);
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getMobileNum() {
		return mobileNum;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Appointment getAppointment() {
		return appointment;
	}

}
