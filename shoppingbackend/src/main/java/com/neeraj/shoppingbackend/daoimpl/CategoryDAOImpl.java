package com.neeraj.shoppingbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neeraj.shoppingbackend.dao.CategoryDAO;
import com.neeraj.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		System.out.println(category.toString());
		try {

			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		String hql="from Category where active=:active";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("active",true);
		return query.getResultList();
	}

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		try {

			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
