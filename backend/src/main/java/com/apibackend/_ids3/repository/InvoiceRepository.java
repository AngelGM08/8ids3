package com.apibackend._ids3.repository;

import com.apibackend._ids3.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
