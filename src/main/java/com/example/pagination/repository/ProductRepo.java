package com.example.pagination.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pagination.entity.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, UUID> {

}
