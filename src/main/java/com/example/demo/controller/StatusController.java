package com.example.demo.controller;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.service.ComplaintStatusService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final ComplaintStatusService complaintStatusService;

    public StatusController(ComplaintStatusService complaintStatusService) {
        this.complaintStatusService = complaintStatusService;
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatus> getStatusHistory(
            @PathVariable Long complaintId) {

        return complaintStatusService.getStatusHistory(complaintId);
    }
}
