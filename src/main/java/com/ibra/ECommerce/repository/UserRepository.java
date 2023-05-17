package com.ibra.ECommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibra.ECommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUser(String email);
	
	List<User> findByFirstName(String fistName);
	
	List<User>findByLastname(String lastName);
	
	List<User>findByFirstNameAndLastName (String firstName, String lastName);
	
	List<User>findByActiveTrue(boolean active);
	
	List<User>findByActiveFalse(boolean active);

}
