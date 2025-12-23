package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository obj;

    @Autowired
    private UserRepository userObj;

    @Autowired
    private PriorityRuleService ruleObj;

    @Autowired
    private ComplaintStatusServiceImpl statusObj;

    public Complaint submitComplaint(Complaint complaint, Long userId) {
        User user = userObj.findById(userId).orElseThrow();
        complaint.setUser(user);
        complaint.setPriorityScore(ruleObj.calculatePriority(complaint.getCategory()));
        Complaint saved = obj.save(complaint);
        statusObj.updateStatus(saved.getId(), "OPEN");
        return saved;
    }

    public List<Complaint> getUserComplaints(Long userId) {
        return obj.findByUserId(userId);
    }

    public List<Complaint> getPrioritizedComplaints() {
        return obj.findAllByOrderByPriorityScoreDescSubmittedOnAsc();
    }

    public void updateComplaintStatus(Long id, String status) {
        statusObj.updateStatus(id, status);
    }
}
