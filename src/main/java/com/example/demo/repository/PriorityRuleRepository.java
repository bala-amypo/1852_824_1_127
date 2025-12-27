package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {

    List<PriorityRule> findByActiveTrue();
}
