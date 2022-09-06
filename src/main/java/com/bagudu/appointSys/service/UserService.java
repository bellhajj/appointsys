package com.bagudu.appointSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bagudu.appointSys.model.Appointment;
import com.bagudu.appointSys.model.User;
import com.bagudu.appointSys.respository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public String saveUser(User user) {
		
		String password = user.generatePassword();
		user.setPassword(password);
		user.setUsername(user.generateUsername());		
		user.setPassword(encoder.encode(password));
		
		userRepository.save(user);
		
		return password;
		
	}
	
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}
	
	public void updateUser(User user, Appointment appointment) {
		
		user.setAppointment(appointment);
		userRepository.save(user);
	}
	
	
	
}
