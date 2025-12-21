package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {

    Optional<PriorityRule> findByCategory(String category);
}
