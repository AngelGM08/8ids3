package com.apibackend._ids3.repository;

import com.apibackend._ids3.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
