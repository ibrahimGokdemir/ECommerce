package com.ibra.ECommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibra.ECommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
