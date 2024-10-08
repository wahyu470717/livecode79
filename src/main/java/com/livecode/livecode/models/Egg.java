package com.livecode.livecode.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "egg")
@NoArgsConstructor
@AllArgsConstructor
public class Egg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eggId;

    @Column(name = "jumlah_telur")
    private int jumlahTelur;

    @Column(name = "pendapatan")
    private double pendapatan;

    @Column(name = "tanggal_peletakan")
    private LocalDate tanggalPeletakan;
}
