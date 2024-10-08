package com.livecode.livecode.controller;

import com.livecode.livecode.models.Egg;
import com.livecode.livecode.services.EggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eggs")
public class EggController {

    @Autowired
    private EggService eggService;

    // API untuk menambahkan telur
    @PostMapping("/add")
    public ResponseEntity<Egg> addEgg(
            @RequestParam int eggCount,
            @RequestParam double pricePerEgg
    ) {
        Egg egg = eggService.addEgg(eggCount, pricePerEgg);
        return ResponseEntity.ok(egg);
    }

    // API untuk mendapatkan semua catatan telur
    @GetMapping("/all")
    public ResponseEntity<List<Egg>> getAllEggs() {
        List<Egg> eggs = eggService.getAllEggs();
        return ResponseEntity.ok(eggs);
    }

    // API untuk mendapatkan total penghasilan
    @GetMapping("/income")
    public ResponseEntity<Double> getTotalIncome() {
        double totalIncome = eggService.getTotalIncome();
        return ResponseEntity.ok(totalIncome);
    }
}
