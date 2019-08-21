package com.shortlist.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shortlist.shoppingcart.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
