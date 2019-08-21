package com.shortlist.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shortlist.shoppingcart.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
