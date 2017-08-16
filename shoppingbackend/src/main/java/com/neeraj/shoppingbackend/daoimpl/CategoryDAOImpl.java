package com.neeraj.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.neeraj.shoppingbackend.dao.CategoryDAO;
import com.neeraj.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		// first category item
		Category c1 = new Category();
		c1.setId(1);
		c1.setName("Television");
		c1.setDescription("Category for televisions");
		c1.setImageUrl("c1.png");
		categories.add(c1);

		// second category item
		c1 = new Category();
		c1.setId(2);
		c1.setName("Mobile");
		c1.setDescription("Category for mobiles");
		c1.setImageUrl("c2.png");
		categories.add(c1);

		// third category item
		c1 = new Category();
		c1.setId(3);
		c1.setName("Laptop");
		c1.setDescription("Category for laptops");
		c1.setImageUrl("c3.png");
		categories.add(c1);
	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {
		for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}
		return null;
	}

}
