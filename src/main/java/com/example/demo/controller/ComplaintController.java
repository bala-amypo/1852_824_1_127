package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService obj;

    @PostMapping("/submit/{userId}")
    public Complaint submit(@RequestBody Complaint complaint, @PathVariable Long userId) {
        return obj.submitComplaint(complaint, userId);
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> userComplaints(@PathVariable Long userId) {
        return obj.getUserComplaints(userId);
    }

    @GetMapping("/prioritized")
    public List<Complaint> prioritized() {
        return obj.getPrioritizedComplaints();
    }

    @PutMapping("/status/{id}")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        obj.updateComplaintStatus(id, status);
    }
}
