package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;
    private final UserService userService;

    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            PriorityRuleService priorityRuleService,
            UserService userService) {

        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
        this.userService = userService;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest request) {
        User user = userService.findById(request.getUserId());

        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCategory(request.getCategory());
        complaint.setUser(String.valueOf(user.getId()));
        complaint.setPriorityScore(
                Long.valueOf(
                        priorityRuleService.calculatePriority(
                                request.getCategory()
                        )
                )
        );
        return complaintRepository.save(complaint);
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
        complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));
    }
}
