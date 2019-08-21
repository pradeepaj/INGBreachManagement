package com.ing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.entity.RuleEngine;

@Repository
public interface RuleEngineRepository extends JpaRepository<RuleEngine, Long> {

	public RuleEngine findByBreachCategoryAndBusinessAreaAndFranchise(String breachCategory, String businessArea,
			String franchise);
}
