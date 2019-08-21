package com.shortlist.shoppingcart.service;

import java.util.Collection;

import com.shortlist.shoppingcart.domain.User;

public interface UserService {

	User add(User u);

	User update(User u);

	Collection<User> findAll();

	void deleteById(Long id);

	User fetchById(Long id);

}
