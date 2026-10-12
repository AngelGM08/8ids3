
package com.apibackend._ids3.controller;

import com.apibackend._ids3.dto.request.InvoiceRequestDTO;
import com.apibackend._ids3.dto.response.InvoiceResponseDTO;
import com.apibackend._ids3.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {
    
    private final InvoiceService invoiceService;
    
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    
    // Obtener todas las facturas
    @GetMapping
    public ResponseEntity<List<InvoiceResponseDTO>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }
    
    // Obtener factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> getInvoiceById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }
    
    // Guardar factura
    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> saveInvoice(@Valid @RequestBody InvoiceRequestDTO dto) {
        InvoiceResponseDTO response = invoiceService.saveInvoice(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    // Actualizar factura
    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> updateInvoice(@PathVariable Long id, @Valid @RequestBody InvoiceRequestDTO dto) {
        return ResponseEntity.ok(invoiceService.updateInvoice(id, dto));
    }
    
    // Eliminar factura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        
        return ResponseEntity.noContent().build();
    }
}