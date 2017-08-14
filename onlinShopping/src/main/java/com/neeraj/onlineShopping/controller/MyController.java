package com.neeraj.onlineShopping.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController {

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView showMessage(Model m){
		System.out.println("hello guys. I reached in controller");
		ModelAndView mv=new ModelAndView("home");
		return mv;
		
	}
	}
