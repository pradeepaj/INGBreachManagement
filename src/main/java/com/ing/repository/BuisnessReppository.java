
package com.ing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.entity.BuisnessArea;

@Repository
public interface BuisnessReppository extends JpaRepository<BuisnessArea, Integer> {

	List<BuisnessArea> findByfid(int id);

}
