package com.bagudu.appointSys.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime appointmentTime;
	

	@JsonBackReference
    @OneToOne(mappedBy = "appointment")
    private User user;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	
	
	public User getUser() {
		return user;
	}
	
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	
}
