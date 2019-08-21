package com.shortlist.shoppingcart.service;

import java.util.Collection;
import java.util.Set;

import com.shortlist.shoppingcart.domain.Item;

public interface ItemService {

	Item add(Item c);

	Item update(Item c);

	Collection<Item> findAll();

	void deleteById(Long id);

	Item fetchById(Long id);

	Collection<Item> addAll(Set<Item> set);

	void addItemsToCart(Long userId, Long cartId, Set<Item> items);

	void removeItemsFromCart(Long userId, Long cartId, Set<Item> items);

	void modifyItemsFromCart(Long userId, Long cartId, Set<Item> items);

}
