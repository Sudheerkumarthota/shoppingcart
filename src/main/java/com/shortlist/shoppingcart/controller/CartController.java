package com.shortlist.shoppingcart.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shortlist.shoppingcart.domain.Cart;
import com.shortlist.shoppingcart.service.CartService;

@RestController
@RequestMapping("carts")
public class CartController {

	CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping
	public Cart add(@RequestBody Cart c) {
		return cartService.add(c);
	}

	@PutMapping
	public Cart update(@RequestBody Cart c) {
		return cartService.add(c);
	}

	@GetMapping("{id}")
	public Cart findById(@PathVariable Long id) {
		return cartService.fetchById(id);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		cartService.deleteById(id);
	}

	@GetMapping
	public Collection<Cart> findAll() {
		return cartService.findAll();
	}

}
