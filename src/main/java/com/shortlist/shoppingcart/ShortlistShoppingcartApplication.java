package com.shortlist.shoppingcart;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.shortlist.shoppingcart.domain.Cart;
import com.shortlist.shoppingcart.domain.Item;
import com.shortlist.shoppingcart.domain.User;
import com.shortlist.shoppingcart.service.CartService;
import com.shortlist.shoppingcart.service.ItemService;
import com.shortlist.shoppingcart.service.UserService;

@EnableAutoConfiguration
@SpringBootApplication
public class ShortlistShoppingcartApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ShortlistShoppingcartApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserService userService, ItemService itemService, CartService cartService) {
		return (String... args) -> {
			User user = invokeUserService(userService);
			Collection<Item> items = invokeItemService(itemService);
			invokeCartService(cartService, userService, items);
		};

	}

	private User invokeUserService(UserService userService) {
		User user = new User();
		user.setEmailId("abcd@gmail.com");
		user.setName("abcd");
		return userService.add(user);
	}

	private void invokeCartService(CartService cartService, UserService userService, Collection<Item> items) {
		Cart cart = new Cart();
		cart.setUser(userService.fetchById(1L));
		cart.setItems(new HashSet<Item>(items));
		cartService.add(cart);
	}

	private Collection<Item> invokeItemService(ItemService itemService) {
		Item item = new Item();
		item.setName("APPLE");
		item.setPrice(123.90);
		item.setQuantity(1);
		Item item2 = new Item();
		item2.setName("MANGO");
		item2.setPrice(123.90);
		item2.setQuantity(1);
		Set<Item> set = new HashSet<Item>();
		set.add(item);
		set.add(item2);
		return itemService.addAll(set);
	}

}
