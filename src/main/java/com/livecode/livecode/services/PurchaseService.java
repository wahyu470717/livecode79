package com.livecode.livecode.services;

import com.livecode.livecode.models.Item;
import com.livecode.livecode.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private ItemRepository itemRepository;

    // Fungsi untuk mencari kombinasi barang yang paling mendekati jumlah uang
    public List<Item> findOptimalPurchase(double budget) {
        List<Item> allItems = itemRepository.findAll();
        List<Item> optimalPurchase = new ArrayList<>();

        findCombination(allItems, new ArrayList<>(), budget, optimalPurchase);

        return optimalPurchase;
    }

    private void findCombination(List<Item> items, List<Item> currentCombination, double remainingBudget, List<Item> optimalPurchase) {
        if (remainingBudget < 0) return;

        double currentTotal = currentCombination.stream().mapToDouble(Item::getPrice).sum();
        double optimalTotal = optimalPurchase.stream().mapToDouble(Item::getPrice).sum();

        if (currentTotal > optimalTotal && currentTotal <= remainingBudget) {
            optimalPurchase.clear();
            optimalPurchase.addAll(currentCombination);
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> newCombination = new ArrayList<>(currentCombination);
            newCombination.add(items.get(i));
            findCombination(items.subList(i + 1, items.size()), newCombination, remainingBudget, optimalPurchase);
        }
    }
}
