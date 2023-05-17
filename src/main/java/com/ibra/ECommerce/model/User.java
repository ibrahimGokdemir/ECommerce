package com.ibra.ECommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private String phoneNumber;
	
	private String city;
	
	@Column(nullable = false)
	private Boolean active;
	
	@Override
	public String toString() {
		
		return "User{" +
				"id= "+id +
				",firstName = " +firstName+
				",lastName = " +lastName+
				",eMail = "+email+
				",phoneNumber = "+phoneNumber+
				",city = "+city+
				"}";
		
	}
	
	

}
