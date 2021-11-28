/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.invoice.controller.scan;

import com.koona.invoise.core.entity.customer.Customer;
import com.koona.invoise.core.entity.invoice.Invoice;
import com.koona.invoise.core.service.InvoiceServiceInterface;
import com.koona.invoise.invoice.controller.InvoiceControllerInterface;

/**
 *
 * @author Steve KOUNA
 */
//@Controller
public class InvoiceDouchetteController  implements InvoiceControllerInterface {
    
    private InvoiceServiceInterface invoiceService;

    @Override
    public String createInvoice(Invoice invoice) {
        invoice = new Invoice();
        System.out.println("Usage of scanner");

        Customer customer = new Customer();
        customer.setName("Virgin Galactic");

        invoice.setCustomer(customer);
        invoiceService.create(invoice);
        return "";
    }

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
    
}
