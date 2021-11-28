/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.invoice.service.number;

import com.koona.invoise.core.entity.invoice.Invoice;
import com.koona.invoise.core.repository.CustomerRepositoryInterface;
import com.koona.invoise.core.repository.InvoiceRepositoryInterface;
import com.koona.invoise.invoice.service.InvoiceServiceInterface;

/**
 *
 * @author Steve KOUNA
 */
//@Service
public class InvoiceNumberService implements InvoiceServiceInterface {
    
    private static Long lastNumber = 0L;

    public static Long getLastNumber() {
        return lastNumber;
    }

    public static void setLastNumber(Long aLastNumber) {
        lastNumber = aLastNumber;
    }

//    @Autowired
    private InvoiceRepositoryInterface invoiceRepository;

//    @Autowired
    private CustomerRepositoryInterface customerRepository;

    
    public Invoice create(Invoice invoice) {
        invoiceRepository.save(invoice);

        return invoice;
    }

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Iterable<Invoice> getInvoiceList() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceByNumber(String number) {
        return this.invoiceRepository.findById(number).orElseThrow();
    }
}
