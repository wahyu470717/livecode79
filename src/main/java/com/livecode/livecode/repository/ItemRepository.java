package com.livecode.livecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livecode.livecode.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
  
}
