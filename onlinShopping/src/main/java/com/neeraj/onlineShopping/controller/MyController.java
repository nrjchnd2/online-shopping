package com.neeraj.onlineShopping.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController {

	@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
	public ModelAndView home(Model m) {
		//System.out.println("hello guys. I reached in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Home");
		m.addAttribute("userHomeClick", true);
		return mv;

	}
	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public ModelAndView about(Model m) {
		//System.out.println("hello guys. I reached in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "About Us");
		m.addAttribute("userAboutClick", true);
		return mv;

	}
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView contact(Model m) {
		//System.out.println("hello guys. I reached in controller");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Contact Us");
		m.addAttribute("userContactClick", true);
		return mv;

	}
	
	}
