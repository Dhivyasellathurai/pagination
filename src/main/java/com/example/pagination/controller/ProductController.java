package com.example.pagination.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagination.entity.ProductDto;
import com.example.pagination.entity.Products;
import com.example.pagination.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/create")
	public void createProduct(@RequestBody ProductDto dto) {
		productService.addProduct(dto);
	}

	@GetMapping("/getAll")
	public List<ProductDto> getAllProducts() {
		return productService.getAll();
	}

	@GetMapping("/getBy/pagination")
	public List<Products> getByPagination(@RequestParam("pageNo") Integer pageNo,
			@RequestParam("pageSize") Integer pageSize) {
		return productService.getAllProductByPagination(pageNo, pageSize);
	}

	@GetMapping("/getAllBy/page")
	public ResponseEntity<?> getAllUsingPagination(@RequestParam("pageNo") Integer pageNo,
			@RequestParam("pageSize") Integer pageSize) {
		Page<Products> prod = productService.getAllProductUsingPagination(pageNo, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Products", prod.getContent());
		map.put("current-page", prod.getNumber());
		map.put("total-elements", prod.getTotalElements());
		map.put("total-page", prod.getTotalPages());
		return ResponseEntity.ok().body(map);
	}
}
