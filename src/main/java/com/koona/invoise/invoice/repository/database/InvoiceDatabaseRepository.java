/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.invoice.repository.database;
/*
import com.koona.invoise.core.entity.Invoice;
import com.koona.invoise.core.repository.InvoiceRepositoryInterface;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDatabaseRepository  implements InvoiceRepositoryInterface {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Invoice> list() {
        return jdbcTemplate.query("SELECT invoice_number, customer_name FROM invoice",
                (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("invoice_number")), rs.getString("customer_name"))
        );
    }

    private static List<Invoice> invoices = new ArrayList<>();
    
    public Invoice create(Invoice invoice) {
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO invoice VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, invoice.getCustomerName());
            ps.setString(2, invoice.getOrderNumber());
            return ps;
        }, kh);

        invoice.setNumber(kh.getKey().toString());

        return invoice;
    }

    @Override
    public Invoice getById(String number) {
        return  jdbcTemplate.queryForObject("SELECT * FROM invoice WHERE invoice_number=?",
                new Object[]{number},
                (rs, rowNum) -> new Invoice(String.valueOf(rs.getLong("invoice_number")), rs.getString("customer_name"), rs.getString("order_number"))
        );
    }
}

 */
