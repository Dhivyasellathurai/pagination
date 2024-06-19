package com.example.pagination.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductDto {

	private String productName;
	private double productPrice;
	private String category;
	private int quantity;
	private LocalDate dateAdded;

}
