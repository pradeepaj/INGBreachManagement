package com.ing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.entity.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	UserDetails findByEmailAndPassword(String email, String password);

}
