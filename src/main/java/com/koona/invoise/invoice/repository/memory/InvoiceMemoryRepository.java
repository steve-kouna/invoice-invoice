/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.invoice.repository.memory;

import com.koona.invoise.core.entity.invoice.Invoice;
import com.koona.invoise.invoice.repository.InvoiceRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Steve KOUNA
 */
//@Repository
public class InvoiceMemoryRepository implements InvoiceRepositoryInterface {
    
    private static List<Invoice> invoices = new ArrayList<>();
    
    public Invoice save(Invoice invoice) {
        invoices.add(invoice);
        
        System.out.println("Invoice addedd with number " + invoice.getNumber() + " for " + invoice.getCustomer().getName());

        return invoice;
    }

    @Override
    public Iterable<Invoice> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Invoice> findAllById(Iterable<String> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Invoice invoice) {

    }

    @Override
    public void deleteAll(Iterable<? extends Invoice> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Invoice> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Invoice> findById(String number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }
}
