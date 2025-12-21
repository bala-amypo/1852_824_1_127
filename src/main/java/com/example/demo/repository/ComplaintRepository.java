package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByUserId(Long userId);

    @Query("SELECT c FROM Complaint c ORDER BY c.priorityScore DESC, c.submittedOn ASC")
    List<Complaint> findAllOrderByPriorityScoreDescCreatedAtAsc();
}
