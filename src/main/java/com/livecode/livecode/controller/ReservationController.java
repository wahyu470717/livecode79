package com.livecode.livecode.controller;

import com.livecode.livecode.models.Reservation;
import com.livecode.livecode.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // API untuk menambahkan reservasi
    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(
            @RequestParam String customerName,
            @RequestParam LocalDate reservationDate
    ) {
        try {
            Reservation reservation = reservationService.addReservation(customerName, reservationDate);
            return ResponseEntity.ok(reservation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // API untuk melihat semua reservasi dalam 1 minggu ke depan
    @GetMapping("/next-week")
    public ResponseEntity<List<Reservation>> getReservationsForNextWeek() {
        List<Reservation> reservations = reservationService.getReservationsForNextWeek();
        return ResponseEntity.ok(reservations);
    }

    // API untuk mendapatkan hari yang tersedia dalam 1 minggu ke depan
    @GetMapping("/available-days")
    public ResponseEntity<List<LocalDate>> getAvailableDaysForNextWeek() {
        List<LocalDate> availableDays = reservationService.getAvailableDaysForNextWeek();
        return ResponseEntity.ok(availableDays);
    }
}
