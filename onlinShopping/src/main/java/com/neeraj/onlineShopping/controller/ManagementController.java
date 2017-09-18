package com.neeraj.onlineShopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neeraj.onlineShopping.utility.FileUploadUtility;
import com.neeraj.onlineShopping.validator.ImageValidator;
import com.neeraj.shoppingbackend.dao.CategoryDAO;
import com.neeraj.shoppingbackend.dao.ProductDAO;
import com.neeraj.shoppingbackend.dto.Category;
import com.neeraj.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value="/products")
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation){
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("title","Manage Products");
		mv.addObject("userClicksManageProducts",true);
		Product p=new Product();
		p.setSupplierId(1);
		p.setActive(true);
		mv.addObject("product",p);
		if(operation!=null){
			
			if(operation.equals("product")){
				mv.addObject("message","Product submitted successfully");
			}
			if(operation.equals("category")){
				mv.addObject("message","Category submitted successfully");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute Product product,BindingResult results, Model model,HttpServletRequest request){
		if(product.getId()==0){
		new ImageValidator().validate(product, results);
		}
		else
		{
			if(! product.getFile().getOriginalFilename().equals("")){
				new ImageValidator().validate(product, results);
			}
		}
		if(results.hasErrors()){
			model.addAttribute("message","The vallidation failed while saving the product");
			model.addAttribute("title","Manage Products");
			model.addAttribute("userClicksManageProducts",true);
			return "home";
		}
		
		if(product.getId()==0){
		productDAO.add(product);
		}
		else{
			productDAO.update(product);
		}
		if(!product.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.upload(request,product.getFile(),product.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
		
	}
	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id){
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("title","Manage Products");
		mv.addObject("userClicksManageProducts",true);
		Product p=productDAO.getProduct(id);
		mv.addObject("product",p);
		return mv;
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String activationProduct(@PathVariable int id){
		Product p=productDAO.getProduct(id);
		boolean currentStatus=p.isActive();
		p.setActive(!p.isActive());
		productDAO.update(p);
		return (currentStatus)?"You have deactivated the product "+id
				:"You have activated the product "+id;
	}
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category){
		
		categoryDAO.addCategory(category);
		return "redirect:/manage/products?operation=category";
	}
	
	@ModelAttribute("categories")
	public List<Category> getAllCategories(){
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
}
