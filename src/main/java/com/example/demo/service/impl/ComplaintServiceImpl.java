package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.*;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            PriorityRuleService priorityRuleService,
            UserService userService) {

        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
        this.userService = userService;
    }

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;
    private final UserService userService;

    @Override
    public Complaint submitComplaint(ComplaintRequest request) {
        User user = userService.findByEmail(
                userService.findByEmail(
                        userService.findByEmail("").getEmail()
                ).getEmail()
        );

        Complaint c = new Complaint();
        c.setTitle(request.title);
        c.setDescription(request.description);
        c.setCategory(request.category);
        c.setUser(user);
        c.setPriorityScore(priorityRuleService.calculatePriority(request.category));

        return complaintRepository.save(c);
    }

    @Override
    public List<Complaint> getUserComplaints(Long userId) {
        return complaintRepository.findByUserId(userId);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }

    @Override
    public void updateComplaintStatus(Long id, String status) {
        Complaint c = complaintRepository.findById(id).orElseThrow();
    }
}
