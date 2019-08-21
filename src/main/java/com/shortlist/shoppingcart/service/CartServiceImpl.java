package com.shortlist.shoppingcart.service;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shortlist.shoppingcart.domain.Cart;
import com.shortlist.shoppingcart.exception.ResourceNotFoundException;
import com.shortlist.shoppingcart.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart add(Cart c) {
		auditFields(c, false);
		return cartRepository.save(c);
	}

	@Override
	public Cart update(Cart c) {
		auditFields(c, true);
		return cartRepository.save(c);
	}

	@Override
	public Collection<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		cartRepository.deleteById(id);
	}

	@Override
	public Cart fetchById(Long id) {
		return cartRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
	}

	private void auditFields(Cart u, boolean isUpdateOperation) {
		if (isUpdateOperation) {
			u.setUpdatedOn(LocalDateTime.now());
		} else {
			u.setCreatedOn(LocalDateTime.now());
			u.setUpdatedOn(LocalDateTime.now());
		}
	}

}
