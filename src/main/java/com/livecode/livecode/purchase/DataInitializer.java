package com.livecode.livecode.purchase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.livecode.livecode.models.Item;
import com.livecode.livecode.repository.ItemRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository) {
        return args -> {
            itemRepository.save(new Item(null, "Mouse", 12000));
            itemRepository.save(new Item(null, "Mouse", 20000));
            itemRepository.save(new Item(null, "Mouse", 35000));
            itemRepository.save(new Item(null, "Keyboard", 25000));
            itemRepository.save(new Item(null,"Keyboard", 30000));
            itemRepository.save(new Item(null,"Keyboard", 45000));
        };
    }
}

