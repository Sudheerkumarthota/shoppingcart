package com.shortlist.shoppingcart.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shortlist.shoppingcart.domain.Cart;
import com.shortlist.shoppingcart.domain.Item;
import com.shortlist.shoppingcart.exception.ResourceNotFoundException;
import com.shortlist.shoppingcart.repository.ItemRepository;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	UserService userService;

	@Autowired
	CartService cartService;

	@Override
	public Item add(Item i) {
		auditFields(i, false);
		return itemRepository.save(i);
	}

	@Override
	public Item update(Item i) {
		auditFields(i, true);
		return itemRepository.save(i);
	}

	@Override
	public Collection<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}

	@Override
	public Item fetchById(Long id) {
		return itemRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void addItemsToCart(Long userId, Long cartId, Set<Item> items) {
		Cart cart = null;
		Set<Cart> carts = null;
		if (isValidUser(userId) && isValidCart(cartId)) {
			cart = cartService.fetchById(cartId);
			carts = new HashSet<Cart>();
			carts.add(cart);
			for (Item i : items) {
				i.setCarts(carts);
			}
		}
		itemRepository.saveAll(items);
	}

	@Override
	public void removeItemsFromCart(Long userId, Long cartId, Set<Item> items) {
		if (isValidUser(userId) && isValidCart(cartId)) {

		}
	}

	@Override
	public void modifyItemsFromCart(Long userId, Long cartId, Set<Item> items) {
		if (isValidUser(userId) && isValidCart(cartId)) {

		}
	}

	private boolean isValidUser(Long userId) {
		if (userService.fetchById(userId) != null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isValidCart(Long cartId) {
		if (cartService.fetchById(cartId) != null) {
			return true;
		} else {
			return false;
		}
	}

	private void auditFields(Item i, boolean isUpdateOperation) {
		if (isUpdateOperation) {
			i.setUpdatedOn(LocalDateTime.now());
		} else {
			i.setCreatedOn(LocalDateTime.now());
			i.setUpdatedOn(LocalDateTime.now());
		}
	}

	@Override
	public Collection<Item> addAll(Set<Item> set) {
		return itemRepository.saveAll(set);
	}

}
