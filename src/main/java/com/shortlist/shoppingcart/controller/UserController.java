package com.shortlist.shoppingcart.controller;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shortlist.shoppingcart.domain.Item;
import com.shortlist.shoppingcart.domain.User;
import com.shortlist.shoppingcart.service.CartService;
import com.shortlist.shoppingcart.service.ItemService;
import com.shortlist.shoppingcart.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	UserService userService;

	CartService cartService;

	ItemService itemService;

	@Autowired
	public UserController(UserService userService, CartService cartService, ItemService itemService) {
		this.userService = userService;
		this.cartService = cartService;
		this.itemService = itemService;
	}

	@PostMapping
	public User add(@RequestBody User u) {
		return userService.add(u);
	}

	@PutMapping
	public User update(@RequestBody User u) {
		return userService.add(u);
	}

	@GetMapping("{id}")
	public User findById(@PathVariable Long id) {
		return userService.fetchById(id);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteById(id);
	}

	@GetMapping
	public Collection<User> findAll() {
		return userService.findAll();
	}

	@PutMapping("{userId}/{operation}/{cartId}")
	public void addItemsToCart(@PathVariable Long userId, @PathVariable String operation, @PathVariable Long cartId,
			@RequestBody Set<Item> items) {

		switch (operation) {
		case "addItemsToCart":
			itemService.addItemsToCart(userId, cartId, items);
			break;
		case "removeItemsFromCart":
			itemService.removeItemsFromCart(userId, cartId, items);
			break;
		case "modifyItemsFromCart":
			itemService.modifyItemsFromCart(userId, cartId, items);
			break;

		}
	}

}
