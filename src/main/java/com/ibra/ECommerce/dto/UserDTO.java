package com.ibra.ECommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String city;
	

}
