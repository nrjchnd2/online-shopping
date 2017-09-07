package com.neeraj.onlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neeraj.onlineShopping.exception.ProductNotFoundException;
import com.neeraj.shoppingbackend.dao.CategoryDAO;
import com.neeraj.shoppingbackend.dao.ProductDAO;
import com.neeraj.shoppingbackend.daoimpl.CategoryDAOImpl;
import com.neeraj.shoppingbackend.dto.Category;
import com.neeraj.shoppingbackend.dto.Product;

@RestController
public class MyController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
	public ModelAndView home(Model m) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Home");
		mv.addObject("categories",categoryDAO.list());
		
		m.addAttribute("userHomeClick", true);
		return mv;

	}
	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public ModelAndView about(Model m) {
		//System.out.println("hello guys. I reached in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "About Us");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userAboutClick", true);
		return mv;

	}
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView contact() {
		//System.out.println("hello guys. I reached in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Contact Us");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userContactClick", true);
		return mv;

	}
	
	@RequestMapping(value="/show/all/products",method=RequestMethod.GET)
	public ModelAndView showAllProducts() {
		//System.out.println("hello guys. I reached in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "All products");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userAllProductsClick", true);
		return mv;

	}
	
	@RequestMapping(value="/show/category/{id}/products",method=RequestMethod.GET)
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		Category category=categoryDAO.get(id);
		
		System.out.println("hello guys. I reached in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title",category.getName());
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("category",category);
		mv.addObject("userCategoryProductsClick", true);
		System.out.println(category);
		return mv;

	}
	
	@RequestMapping(value="/show/{id}/product",method=RequestMethod.GET)
	public ModelAndView showOneProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv=new ModelAndView("home");
		Product product=productDAO.getProduct(id);
		if(product==null)
			throw new ProductNotFoundException();
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickOneProduct",true);
	    return mv;
	}
	
	
	}
