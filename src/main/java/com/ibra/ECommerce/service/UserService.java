package com.ibra.ECommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibra.ECommerce.dto.UserDTO;
import com.ibra.ECommerce.model.User;
import com.ibra.ECommerce.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	
	public List<User> getAllUsers(){   //Tüm kullanıcıları döndüren metod
		return userRepository.findAll();
	}
	
	public User GetUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Tanımsız kullanıcı ID'si: " + id));
		
	}
	
	public User createUser(UserDTO userDTO) {
		
		User user = new User(); //Yeni user nesnesi oluşturuyoruz.
		
		user.setFirstName(userDTO.getFirstName());	//aldığımız nesneyi aktarıyoruz.
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setCity(userDTO.getCity());
		user.setActive(true);					//Kullanıcı varsayılan olarak aktif olarak oluşturuluyor.
		
		return userRepository.save(user);
		
	}
	
	public User updateUser(Long id, UserDTO userDTO) {
		// İlgili kullanıcıyı kimliğiyle birlikte alıyoruz
        // Eğer kullanıcı bulunamazsa IllegalArgumentException fırlatıyoruz
		User user = userRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Yanlış kullanıcı ID'si : " +id));
	
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setCity(userDTO.getCity());
		
		return userRepository.save(user);
	}
	
	
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
