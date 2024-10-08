package com.livecode.livecode.controller;

import com.livecode.livecode.models.Item;
import com.livecode.livecode.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // API untuk mencari kombinasi barang optimal
    @GetMapping("/optimal")
    public ResponseEntity<List<Item>> getOptimalPurchase(@RequestParam double budget) {
        List<Item> optimalPurchase = purchaseService.findOptimalPurchase(budget);
        return ResponseEntity.ok(optimalPurchase);
    }
}
