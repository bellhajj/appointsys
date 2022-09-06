package com.bagudu.appointSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagudu.appointSys.model.Appointment;
import com.bagudu.appointSys.respository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
		
	public void saveAppointment(Appointment appointment) {		
		
		appointmentRepository.save(appointment);		
	}
	
	public boolean checkAppointmentDateAndTime(Appointment appointment) {
		
		Appointment appoint1 = appointmentRepository.findByAppointmentTime(appointment.getAppointmentTime());
		
		Appointment appoint2 = appointmentRepository.findByAppointmentDate(appointment.getAppointmentDate());
		
		if(appoint1 == null || appoint2 == null) {			
			
			return false;
			
		}else if(appointment.getAppointmentDate().isEqual(appoint2.getAppointmentDate()) && 
				appointment.getAppointmentTime().getHour() == appoint1.getAppointmentTime().getHour()) {
					
			return true;
			
		}
		return false;
		
	}


}
