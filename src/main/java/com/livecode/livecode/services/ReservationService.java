package com.livecode.livecode.services;

import com.livecode.livecode.models.Reservation;
import com.livecode.livecode.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Menambahkan reservasi
    public Reservation addReservation(String customerName, LocalDate reservationDate) throws Exception {
        if (reservationDate.getDayOfWeek() == DayOfWeek.WEDNESDAY || reservationDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
            throw new Exception("Hari Rabu dan Jumat tidak tersedia untuk reservasi.");
        }

        List<Reservation> reservationsForDay = reservationRepository.findByReservationDate(reservationDate);
        if (reservationsForDay.size() >= 2) {
            throw new Exception("Sudah ada 2 reservasi untuk hari ini.");
        }

        Reservation reservation = new Reservation(null, customerName, reservationDate);
        return reservationRepository.save(reservation);
    }

    // Mendapatkan semua reservasi dalam 1 minggu dari tanggal sekarang
    public List<Reservation> getReservationsForNextWeek() {
        LocalDate today = LocalDate.now();
        LocalDate oneWeekLater = today.plusDays(7);

        return reservationRepository.findAll()
                .stream()
                .filter(reservation -> !isDayOff(reservation.getReservationDate()) && 
                        (reservation.getReservationDate().isAfter(today) || reservation.getReservationDate().isEqual(today)) &&
                        reservation.getReservationDate().isBefore(oneWeekLater))
                .collect(Collectors.toList());
    }

    // Memeriksa apakah hari tersebut libur (Rabu dan Jumat)
    private boolean isDayOff(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.WEDNESDAY || date.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    // Mendapatkan hari yang tersedia dalam 1 minggu (kecuali Rabu dan Jumat)
    public List<LocalDate> getAvailableDaysForNextWeek() {
        LocalDate today = LocalDate.now();
        return IntStream.range(0, 7)
                .mapToObj(today::plusDays)
                .filter(date -> !isDayOff(date))
                .collect(Collectors.toList());
    }
}
