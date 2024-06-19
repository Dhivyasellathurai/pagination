package com.example.pagination.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pagination.entity.ProductDto;
import com.example.pagination.entity.Products;
import com.example.pagination.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	public void addProduct(ProductDto product) {
		Products products = Products.builder().productName(product.getProductName())
				.productPrice(product.getProductPrice()).category(product.getCategory()).quantity(product.getQuantity())
				.dateAdded(product.getDateAdded()).build();
		productRepo.save(products);
	}

	public List<ProductDto> getAll() {
		List<Products> list = productRepo.findAll();
		List<ProductDto> dtos = new ArrayList<ProductDto>();
		for (Products products : list) {
			ProductDto dto = new ProductDto();
			dto.setProductName(products.getProductName());
			dto.setProductPrice(products.getProductPrice());
			dto.setCategory(products.getCategory());
			dto.setQuantity(products.getQuantity());
			dto.setDateAdded(products.getDateAdded());
			dtos.add(dto);
		}
		return dtos;
	}

	public List<Products> getAllProductByPagination(int pageNo, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by("productPrice"));
		Page<Products> pagingUser = productRepo.findAll(pageRequest);
		return pagingUser.getContent();
	}

	public Page<Products> getAllProductUsingPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return productRepo.findAll(pageable);
	}
}
