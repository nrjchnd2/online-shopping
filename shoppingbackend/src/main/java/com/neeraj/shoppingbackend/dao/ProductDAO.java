package com.neeraj.shoppingbackend.dao;

import java.util.List;

import com.neeraj.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product getProduct(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean delete(Product product);
	boolean update(Product product);
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}
