/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.invoice.controller.keyboard;

import com.koona.invoise.core.entity.customer.Customer;
import com.koona.invoise.core.entity.invoice.Invoice;
import com.koona.invoise.core.service.InvoiceServiceInterface;
import com.koona.invoise.invoice.controller.InvoiceControllerInterface;

import java.util.Scanner;

/**
 *
 * @author Steve KOUNA
 */
//@Controller
public class InvoiceKeyBoardController implements InvoiceControllerInterface {
    
    private InvoiceServiceInterface invoiceService;
    
    public String createInvoice(Invoice invoice) {
        invoice = new Invoice();
        System.out.println( "What is customer name : " );
        Scanner scanner = new Scanner(System.in);
        String customerName = scanner.nextLine();

        Customer customer = new Customer();
        customer.setName(customerName);
        
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
