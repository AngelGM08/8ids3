package com.apibackend._ids3.service;

import com.apibackend._ids3.dto.request.InvoiceRequestDTO;
import com.apibackend._ids3.dto.response.InvoiceResponseDTO;
import com.apibackend._ids3.exception.InvoiceNotFoundException;
import com.apibackend._ids3.mapper.InvoiceMapper;
import com.apibackend._ids3.model.Invoice;
import com.apibackend._ids3.model.User;
import com.apibackend._ids3.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final UserService userService;
    
    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, UserService userService) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.userService = userService;
    }
    
    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream().map(invoiceMapper::toResponseDTO).toList();
    }
    
    public InvoiceResponseDTO getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(()->new InvoiceNotFoundException(id));
        return invoiceMapper.toResponseDTO(invoice);
    }
    
    public Invoice getInvoiceId(Long id){
        return invoiceRepository.findById(id).orElseThrow(()->new InvoiceNotFoundException(id));
    }
    
    public InvoiceResponseDTO saveInvoice(InvoiceRequestDTO dto) {
        User client = userService.getClientById(dto.getClientId());
        Invoice invoice = invoiceMapper.toEntity(dto, client);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.toResponseDTO(savedInvoice);
    }
    
    public InvoiceResponseDTO updateInvoice(Long id, InvoiceRequestDTO dto) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException(id));
        
        User client = userService.getClientById(dto.getClientId());
        
        invoice.setClient(client);
        invoice.setDate(dto.getDate());
        invoice.setAmount(dto.getAmount());
        invoice.setObservations(dto.getObservations());
        
        Invoice updatedInvoice = invoiceRepository.save(invoice);
        
        return invoiceMapper.toResponseDTO(updatedInvoice);
    }
    
    public void deleteInvoice(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException(id));
        
        invoiceRepository.delete(invoice);
    }
}
