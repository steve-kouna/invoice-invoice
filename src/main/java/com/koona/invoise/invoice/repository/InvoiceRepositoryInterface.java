/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.invoice.repository;

import com.koona.invoise.core.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Steve KOUNA
 */
public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {

}
