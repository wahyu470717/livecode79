package com.livecode.livecode.repository;

import java.time.LocalDate;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.livecode.livecode.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
  List<Reservation> findByReservationDate(LocalDate reservationDate);
}
