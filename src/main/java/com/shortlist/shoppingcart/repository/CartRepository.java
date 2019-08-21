package com.shortlist.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shortlist.shoppingcart.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
