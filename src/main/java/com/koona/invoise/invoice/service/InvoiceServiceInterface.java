/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.invoice.service;

import com.koona.invoise.core.entity.invoice.Invoice;
import com.koona.invoise.core.repository.InvoiceRepositoryInterface;

/**
 *
 * @author Steve KOUNA
 */
public interface InvoiceServiceInterface {
    Invoice create(Invoice invoice);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
    Iterable<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
}
