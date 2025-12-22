package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    private final PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }
    @GetMapping("/all")
    public List<PriorityRule> getAllRules() {
        return priorityRuleService.getAllRules();
    }
}
