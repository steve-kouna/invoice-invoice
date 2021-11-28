/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.invoise.invoice.api;

//import com.koona.invoiceweb.form.InvoiceForm;
import com.koona.invoise.core.entity.customer.Customer;
import com.koona.invoise.core.entity.invoice.Invoice;
import com.koona.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steve KOUNA
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;

    private WebClient.Builder webClientBuilder;

/*
    @PostMapping
    public Invoice postInvoice(
            @RequestBody InvoiceForm invoiceForm,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()){
            return null;
        }
        Invoice invoice = new Invoice();
        Customer customer = new Customer();
        invoice.setNumber(invoiceForm.getNumber());
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        customer.setName(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);

        return invoiceService.create(invoice);
    }

 */

    @GetMapping
    public ParallelFlux<Invoice> getInvoices() {
        System.out.println("La methode display home a ete invoquee !");
        List<Mono<Invoice>> invoiceMono = new ArrayList<>();
        final WebClient webClient = webClientBuilder.baseUrl("http://customer-service").build();
        Iterable<Invoice> invoices =  invoiceService.getInvoiceList();
        invoices.forEach(invoice -> {
//            invoice.setCustomer(restTemplate.getForObject("http://customer-service/customer/" + invoice.getIdCustomer(), Customer.class));
            invoiceMono.add(webClient.get()
                    .uri("/customer/" + invoice.getIdCustomer())
                    .retrieve()
                    .bodyToMono(Customer.class)
                    .map(customer -> {
                        invoice.setCustomer(customer);
                        return invoice;
                    }));
        });

        final Flux<Invoice> invoiceFlux = Flux.concat();

        return invoiceFlux.parallel().runOn(Schedulers.elastic());

    }
/*
    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable("id") String number) {
        System.out.println("La methode displayInvoice a ete invoquee !");
        return invoiceService.getInvoiceByNumber(number);
    }

    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoiceForm) {

        return "invoice-create-form";
    }

 */

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WebClient.Builder getWebClientBuilder() {
        return webClientBuilder;
    }

    public void setWebClientBuilder(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }
}
