package com.bagudu.appointSys.respository;

import java.time.LocalDate;
import java.time.LocalTime;

//import java.time.LocalTime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bagudu.appointSys.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

	Appointment findByAppointmentTime(LocalTime appointmentTime);
	
	Appointment findByAppointmentDate(LocalDate appointmentDate);
}
