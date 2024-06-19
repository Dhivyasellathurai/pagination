package com.example.pagination.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.pagination.entity.Products;

public interface PaginationRepo extends PagingAndSortingRepository<Products, UUID> {

	Page<Products> findAll(Pageable pageable);

}
