package com.livecode.livecode.services;

import com.livecode.livecode.models.Egg;
import com.livecode.livecode.repository.EggRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EggService {

    @Autowired
    private EggRepository eggRepository;

    // Menambahkan telur yang dihasilkan ayam
    public Egg addEgg(int eggCount, double pricePerEgg) {
        double income = eggCount * pricePerEgg;
        Egg egg = new Egg(null, eggCount, income, LocalDate.now());
        return eggRepository.save(egg);
    }

    // Mendapatkan semua catatan telur
    public List<Egg> getAllEggs() {
        return eggRepository.findAll();
    }

    // Menghitung total penghasilan
    public double getTotalIncome() {
        return eggRepository.findAll()
                .stream()
                .mapToDouble(Egg::getPendapatan)
                .sum();
    }
}
