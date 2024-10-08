package com.livecode.livecode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livecode.livecode.models.Ticket;
import com.livecode.livecode.services.TicketService;

@RestController
@RequestMapping("/api/tickets/")
public class TicketController {

  @Autowired
  private TicketService ticketService;
  
  @PostMapping("/beli")
  
    public Ticket beliTiket(@RequestParam String jenisTiket, @RequestParam double harga) {
        return ticketService.buyTicket(jenisTiket, harga);
    }

    // Endpoint untuk melihat semua tiket yang terjual
    @GetMapping("/all")
    public List<Ticket> getAllTiket() {
        return ticketService.getAllTiket();
    }

    // Endpoint untuk melihat total penjualan
    @GetMapping("/totalPenjualan")
    public double totalPenjualan() {
        return ticketService.totalPenjualan();
    }
}
