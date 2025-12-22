package com.example.demo.service.impl;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.repository.ComplaintStatusRepository;
import com.example.demo.service.ComplaintStatusService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    private final ComplaintStatusRepository complaintStatusRepository;

    public ComplaintStatusServiceImpl(
            ComplaintStatusRepository complaintStatusRepository) {
        this.complaintStatusRepository = complaintStatusRepository;
    }

    @Override
    public List<ComplaintStatus> getStatusHistory(Long complaintId) {
        return complaintStatusRepository.findByComplaintId(complaintId);
    }
}
