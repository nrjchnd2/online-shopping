package com.neeraj.shoppingbackend.dao;

import java.util.List;

import com.neeraj.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
