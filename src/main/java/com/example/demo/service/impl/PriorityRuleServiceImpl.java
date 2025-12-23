package com.example.demo.service.impl;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    @Autowired
    private PriorityRuleRepository obj;

    public int calculatePriority(String category) {
        return obj.findByCategory(category)
                .map(PriorityRule::getBaseScore)
                .orElse(0);
    }

    public List<PriorityRule> getAllRules() {
        return obj.findAll();
    }
}
