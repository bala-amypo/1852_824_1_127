package com.example.demo.controller;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.service.ComplaintService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final ComplaintService complaintService;

    public StatusController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> getStatusHistory(
            @PathVariable Long complaintId) {

        return complaintService.getStatusHistory(complaintId);
    }
}
