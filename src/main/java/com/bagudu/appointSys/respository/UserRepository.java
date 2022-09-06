package com.bagudu.appointSys.respository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bagudu.appointSys.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);

}
