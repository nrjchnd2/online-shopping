package com.neeraj.shoppingbackend.dao;

import java.util.List;

import com.neeraj.shoppingbackend.dto.Category;

public interface CategoryDAO {

	boolean addCategory(Category category);
	List<Category> list();
	Category get(int id);
	boolean update(Category category);
	boolean delete(Category category);
}
