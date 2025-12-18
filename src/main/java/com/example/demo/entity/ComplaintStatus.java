package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDateTime;

@Entity
public class ComplaintStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String complaint;
    private String status;
    private String updatedOn;
  public ComplaintStatus() {
    }

    public ComplaintStatus(Long id, String status, String complaint,String updatedOn) {
        this.id = id;
        this.status = status;
        this.complaint = complaint;
        this.updatedOn = updatedOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}
