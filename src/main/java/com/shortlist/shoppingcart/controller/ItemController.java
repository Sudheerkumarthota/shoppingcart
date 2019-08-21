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

import com.shortlist.shoppingcart.domain.Item;
import com.shortlist.shoppingcart.service.ItemService;

@RestController
@RequestMapping("items")
public class ItemController {

	ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping
	public Item add(@RequestBody Item c) {
		return itemService.add(c);
	}

	@PutMapping
	public Item update(@RequestBody Item c) {
		return itemService.add(c);
	}

	@GetMapping("{id}")
	public Item findById(@PathVariable Long id) {
		return itemService.fetchById(id);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		itemService.deleteById(id);
	}

	@GetMapping
	public Collection<Item> findAll() {
		return itemService.findAll();
	}

}
