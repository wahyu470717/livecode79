package com.livecode.livecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livecode.livecode.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
 
}
