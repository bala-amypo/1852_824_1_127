package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    @Autowired
    private PriorityRuleService obj;

    @GetMapping("/all")
    public List<PriorityRule> getRules() {
        return obj.getAllRules();
    }
}
