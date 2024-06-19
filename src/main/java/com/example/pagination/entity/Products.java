package com.example.pagination.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_details")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String productName;
	private double productPrice;
	private String category;
	private int quantity;
	private LocalDate dateAdded;
}
