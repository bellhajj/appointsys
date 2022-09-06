package com.bagudu.appointSys.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bagudu.appointSys.model.Appointment;
import com.bagudu.appointSys.model.User;
import com.bagudu.appointSys.service.AppointmentService;
import com.bagudu.appointSys.service.UserService;

@Controller
public class AppointmentController {
	
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private UserService userService;
			
	@RequestMapping("/book")
	public String bookAppointment() {
		return "book";
	}
	
	@PostMapping("/book/appointment")
	public String saveAppointment(Appointment appointment, RedirectAttributes redirAttrs, Principal principal) {		
		
		boolean check = appointmentService.checkAppointmentDateAndTime(appointment);
		
		if(check == true) {
			
			redirAttrs.addFlashAttribute("error", "The Date and Time has already been choosen");
	        return "redirect:/book";			
						
		}else {
			
			appointmentService.saveAppointment(appointment);
			String username = principal.getName();
			User user = userService.findByUsername(username);
			userService.updateUser(user, appointment);
			
			redirAttrs.addFlashAttribute("success", "Booked Successfully");
		    return "redirect:/book";			
			
		}		
	}
	
	@RequestMapping("/booksuccess")
	public String bookSuccess() {
		return "booking_success";
	}

}
