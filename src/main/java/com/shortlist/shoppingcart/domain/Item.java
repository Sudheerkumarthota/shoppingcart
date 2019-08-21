package com.shortlist.shoppingcart.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Double price;

	private Integer quantity;

	@ManyToMany(mappedBy = "items")
	@JsonBackReference
	Set<Cart> carts;

	private LocalDateTime createdOn;

	private LocalDateTime updatedOn;

}
