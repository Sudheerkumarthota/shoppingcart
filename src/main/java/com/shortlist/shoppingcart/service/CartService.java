package com.shortlist.shoppingcart.service;

import java.util.Collection;

import com.shortlist.shoppingcart.domain.Cart;

public interface CartService {

	Cart add(Cart c);

	Cart update(Cart c);

	Collection<Cart> findAll();

	void deleteById(Long id);

	Cart fetchById(Long id);

}
