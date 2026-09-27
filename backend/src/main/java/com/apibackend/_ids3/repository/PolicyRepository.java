package com.apibackend._ids3.repository;

import com.apibackend._ids3.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    boolean existsByClientId(Long clientId);
    
    List<Policy> findAllByClientId(Long clientId);
}
