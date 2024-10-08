package com.livecode.livecode.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livecode.livecode.models.Ticket;
import com.livecode.livecode.repository.TicketRepository;

@Service
public class TicketService {
  
    @Autowired
    private TicketRepository ticketRepository;

    // Method untuk membeli tiket
    public Ticket buyTicket(String jenisTiket, double harga) {
        Ticket ticket = new Ticket(null, jenisTiket, harga, LocalDate.now());
        return ticketRepository.save(ticket);
    }

    // Method untuk mendapatkan semua tiket
    public List<Ticket> getAllTiket() {
        return ticketRepository.findAll();
    }

    // Method untuk menghitung total penjualan
    public double totalPenjualan() {
        return ticketRepository.findAll()
              .stream()
              .mapToDouble(Ticket::getHarga)  
              .sum();
    }
}
